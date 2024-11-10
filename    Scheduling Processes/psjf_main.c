#include <stdio.h>
#include <stdlib.h>
#include "doubly_linked_list.h"
#include "coordinator.h"
#include "priority_queue.h"
#include "read_file.h"

void print_all_processes(simulation_t* s, doubly_linked_list_t* dll) {
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
  node_t* running_temp = NULL;
  node_t* temp = (node_t*)malloc(sizeof(node_t));
  process_t* temp_proc = (process_t*)malloc(sizeof(process_t));
  temp = dll->head;
  while (temp != NULL && temp->process->arrival_time > s->total_runtime) {
    if (temp->process->requesting_IO) {
      temp = temp->next;
      continue;
    }
    temp = temp->next;
  }
  if (temp != NULL && s->total_runtime >= temp->process->arrival_time) {
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
      increment_total_time(temp_proc);
    }
    temp = temp->next;
  }
  if (running_temp != NULL) {
    if (running_temp->process->burst_time > 0) {
      priority_push(running_temp, dll);
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
  int timeslices[1] = {1};
  simulation_t* s = create_simulation(1, timeslices);
  print_start();
  process_t** processes = (process_t**)malloc(sizeof(process_t*)*100);
  char* filename = argv[1];
  FILE *fp = fopen(filename, "r");
  int ch = 0;
  int lines = 1;
  while ((ch = fgetc(fp)) != EOF) {
    if (ch == '\n') {
      lines++;
    }
    fclose(fp);
  }
  lines++;
  processes = parse_file("input.txt");
  int i = 0;
  for (i = 0; i < lines; i++) {
    priority_push(create_node(processes[i]), s->dll_array[0]);
    s->num_jobs++;
  }
  print_all_processes(s, s->dll_array[0]);
  while (s->dll_array[0]->length > 0) {
    run_one_iteration(s->dll_array[0], s);
    print_all_processes(s, s->dll_array[0]);
    s->total_runtime++;
  }
  print_complete(s);
  return 0;
}
