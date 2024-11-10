#include <stdio.h>
#include <stdlib.h>
#include "doubly_linked_list.h"
#include "coordinator.h"

simulation_t* create_simulation(int num_queues, int timeslices[]) {
  simulation_t* s = (simulation_t*)malloc(sizeof(simulation_t));
  s->total_runtime = 0;
  s->num_jobs = 0;
  s->shortest_completion_time = 1000000;
  s->longest_completion_time = 0;
  s->total_completion_time = 0;
  s->total_ready_time = 0;
  s->total_io_time = 0;
  int i = 0;
  s->dll_array = (doubly_linked_list_t**)malloc(sizeof(doubly_linked_list_t)*num_queues);
  for (i = 0; i < num_queues; i++) {
    s->dll_array[i] = create_list(timeslices[i]);
  }
  s->num_queues = num_queues;
  return s;
}

node_t* create_job(int burst, int arrival, int pid, simulation_t* s) {
  process_t* proc = create_process(burst, arrival, pid);
  node_t* node = create_node(proc);
  s->num_jobs++;
  return node;
}

simulation_t* free_simulation(simulation_t* s) {
  free(s);
}

void print_start() {
  printf("========+=================+=================+=============+\n");
  printf("|       | Total time      | Total time      | Total time  |\n");
  printf("| Job # | in ready to run | in sleeping on  | in system   |\n");
  printf("|       | state           | I/O state       |             |\n");
  printf("========+=================+=================+=============+\n");
}

void print_process(process_t* proc) {
  
  int pid = proc->pid;
  int ready_time = proc->ready_time;
  int io_time = proc->io_time;
  int total_time = proc->total_time;
  
  
  printf("========+=================+=================+=============+\n");
  printf("| %5d |   %5d         |   %5d         |   %5d     |\n", pid, ready_time, io_time, total_time);
}

void print_complete(simulation_t* s) {
  printf("========+=================+=================+=============+\n");
  printf("Total simulation run time: %d\n", s->total_runtime+1);
  printf("Total number of jobs: %d\n", s->num_jobs);
  printf("Shortest job completion time: %d\n", s->shortest_completion_time);
  printf("Longest job completion time: %d\n", s->longest_completion_time);
  printf("Average job completion time: %d\n", s->total_completion_time / s->num_jobs);
  printf("Average time in ready queue: %d\n", s->total_ready_time / s->num_jobs);
  printf("Average time sleeping in I/O state: %d\n", s->total_io_time / s->num_jobs);
}
