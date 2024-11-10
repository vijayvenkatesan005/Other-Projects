#ifndef process
#endif

#include <stdbool.h>

typedef struct process {
	int burst_time;
	int arrival_time;
	int pid;
        int ready_time;
        int io_time;
        int total_time;
        int priority;
        int time_in_queue;
        bool requesting_IO;
} process_t;

void change_priority(process_t* process, int priority);

void increment_running_time(process_t* process);

void increment_total_time(process_t* process);

void increment_io_time(process_t* process);

void increment_ready_time(process_t* process);

process_t * create_process(int burst_time, int arrival_time, int pid);

void destroy_process(process_t * process);

void decrement_burst_time(process_t * process, int decrement_amount);

void request_io(process_t* process);

void is_io_complete(process_t* process);
