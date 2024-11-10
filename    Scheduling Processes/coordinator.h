#include <stdio.h>
#include <stdlib.h>

typedef struct simulation {
  int total_runtime;
  int num_jobs;
  int shortest_completion_time;
  int longest_completion_time;
  int total_completion_time;
  int total_ready_time;
  int total_io_time;
  int num_queues;
  struct doubly_linked_list** dll_array;
} simulation_t;

node_t* create_job(int pid, int arrival, int burst, simulation_t* s);
simulation_t* create_simulation();
simulation_t* free_simulation(simulation_t* s);
void print_start();
void print_process(process_t* proc);
void print_complete();
