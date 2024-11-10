#include "process.h"
#include <stdlib.h>
#include <stdio.h>
#include <stdbool.h>
#define IO_REQUEST 10
#define IO_COMPLETE 4

process_t * create_process(int burst_time, int arrival_time, int pid) {
	process_t * process = (process_t *)malloc(sizeof(process_t));
	process->burst_time = burst_time;
	process->arrival_time = arrival_time;
	process->pid = pid;
	process->ready_time = 0;
	process->io_time = 0;
	process->total_time = 0;
	process->priority = 0;
	process->time_in_queue = 0;
	return process;
}

void increment_io_time(process_t* process) {
  process->io_time++;
}

void increment_ready_time(process_t* process) {
  process->ready_time++;
}

void increment_total_time(process_t* process) {
  process->total_time++;
}

void destroy_process(process_t * process) {
	free(process);
}

void decrement_burst_time(process_t * process, int decrement_amount) {
	process->burst_time -= decrement_amount;
}

void request_io(process_t* process) {
        int io_activation = rand() % 11;
	if (io_activation == IO_REQUEST) {
	  process->requesting_IO = true;
	  printf("PID %d requesting I/O\n", process->pid);
	}
}

void is_io_complete(process_t* process) {
        int io_deactivation = rand() % 11;
	if (io_deactivation == IO_COMPLETE) {
	  process->requesting_IO = false;
	  printf("PID %d finished I/O.\n", process->pid);
	}
}
