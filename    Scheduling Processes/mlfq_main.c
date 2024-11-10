#include <stdio.h>
#include <stdlib.h>
#include "doubly_linked_list.h"
#include "coordinator.h"
#include "read_file.h"

int clock = 1;
int reset_priorities = 16;
int num_queues = 3;

void downgrade_processes(simulation_t* s) {
  int i = 0;
  for (i = 0; i < num_queues; i++) {
    int timeslice = s->dll_array[i]->timeslice;
    node_t* node = (node_t*)malloc(sizeof(node_t));
    node = s->dll_array[i]->head;
    while (node != NULL) {
      if (node->process->time_in_queue == timeslice) {
	if (node->process->priority < s->num_queues-1) {
	  node = pop_l(s->dll_array[node->process->priority]);
	  node->process->priority++;
	  push_r(node, s->dll_array[node->process->priority]);
	  node->process->time_in_queue = 0;
	}
      }
      node = node->next;
    }
  }
}

void upgrade_all(simulation_t* s) {
  node_t* temp = (node_t*)malloc(sizeof(node_t));
  int q = 1;
  for (q = 1; q < num_queues; q++) {
    if (!is_empty(s->dll_array[q])) {
      temp = pop_l(s->dll_array[q]);
      push_r(temp, s->dll_array[0]);
      temp->process->priority = 0;
      temp->process->time_in_queue = 0;
    }
  }
}
      

void print_all_processes(simulation_t* s) {
  int i = 0;
  for (i = 0; i < num_queues; i++) {
    doubly_linked_list_t* dll = (doubly_linked_list_t*)malloc(sizeof(doubly_linked_list_t));
    dll = s->dll_array[i];
    if (dll->head != NULL) {
      node_t* temp = (node_t*)malloc(sizeof(node_t));
      process_t* proc = (process_t*)malloc(sizeof(process_t));
      temp = dll->head;
      while (temp != NULL) {
	proc = temp->process;
	if (s->total_runtime >= proc->arrival_time - 1) {
	  print_process(proc);
	}
	temp = temp->next;
      }
    }
  }
}

void run_process(node_t* temp) {
  process_t* proc = (process_t*)malloc(sizeof(process_t));
  proc = temp->process;
  request_io(proc);
  if (proc->requesting_IO) {
    increment_io_time(proc);
    is_io_complete(proc);
  }
  if (!proc->requesting_IO) {
    decrement_burst_time(proc, 1);
    increment_total_time(proc);
  }
}

void run_one_iteration(doubly_linked_list_t* dll, simulation_t* s) {
  node_t* running_temp = (node_t*)malloc(sizeof(node_t));
  node_t* temp = (node_t*)malloc(sizeof(node_t));
  process_t* temp_proc = (process_t*)malloc(sizeof(process_t));
  temp = dll->head;
  temp->process->time_in_queue++;
  while (temp != NULL && temp->process->arrival_time > s->total_runtime) {
    if (temp->process->requesting_IO) {
      temp = temp->next;
      continue;
    }
    temp = temp->next;
  }
  if (temp != NULL && s->total_runtime >= temp->process->arrival_time) {
    printf("PID: %d\n", temp->process->pid);
    running_temp = pop_m(temp, dll);
    run_process(running_temp);
  }
  temp = dll->head;
  while (temp != NULL) {
    temp_proc = temp->process;
    if (s->total_runtime < temp_proc->arrival_time) {
      temp = temp->next;
      continue;
    }
    if (temp_proc->requesting_IO) {
      increment_io_time(temp_proc);
      is_io_complete(temp_proc);
    } else {
      increment_ready_time(temp_proc);
    }
    temp = temp->next;
  }
  if (running_temp != NULL) {
    if (running_temp->process->burst_time > 0) {
      push_r(running_temp, dll);
    } else {
      s->total_completion_time += running_temp->process->total_time;
      s->total_ready_time += running_temp->process->ready_time;
      s->total_io_time += running_temp->process->io_time;
      printf("PID %d terminated\n", running_temp->process->pid);
      if (running_temp->process->total_time < s->shortest_completion_time) {
	s->shortest_completion_time = running_temp->process->total_time;
      }
      if (running_temp->process->total_time > s->longest_completion_time) {
	s->longest_completion_time = running_temp->process->total_time;
      }
    }
  }
}

int main(int argc, char** argv) {
  char* filename = argv[1];
  int timeslices[3] = {1, 2, 3};
  simulation_t* s = create_simulation(3, timeslices);
  print_start();
  process_t** processes = (process_t**)malloc(sizeof(process_t*)*100);
  FILE *fp = fopen(filename, "r");
  int ch = 0;
  int lines = 0;
  while ((ch = getc(fp)) != EOF) {
    if (ch == '\n') {
      lines++;
    }
  }
  processes = parse_file(filename);
  int i = 0;
  for (i = 0; i < lines; i++) {
    push_r(create_node(processes[i]), s->dll_array[0]);
    s->num_jobs++;
  }
  print_all_processes(s);
  int empty_queues = 0;
  while (empty_queues != num_queues) {
    int i = 0;
    while (is_empty(s->dll_array[i]) && i < num_queues) {
      i++;
    }
    // This means that all the queues are empty. Time to end.
    run_one_iteration(s->dll_array[i], s);
    // if (i == num_queues-1 && is_empty(s->dll_array[i])) {
    // break;
    // }
    print_all_processes(s);
    clock++;
    s->total_runtime++;
    downgrade_processes(s);
    if (clock % reset_priorities == 0) {
      upgrade_all(s);
    }
    empty_queues = 0;
    for (i = 0; i < num_queues; i++) {
      if (is_empty(s->dll_array[i])) {
	empty_queues++;
      }
    }
  }
  print_complete(s);
  return 0;
}
