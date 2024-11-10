CC = gcc
CFLAGS = -I

TARGETS = psjf round_robin mlfq

PSJF_SRC = psjf_main.c doubly_linked_list.c coordinator.c read_file.c process.c priority_queue.c 

ROUND_ROBIN_SRC = round_robin_main.c doubly_linked_list.c coordinator.c read_file.c process.c

MLFQ_SRC = mlfq_main.c doubly_linked_list.c coordinator.c read_file.c process.c


all: psjf round_robin mlfq

psjf: 
	$(CC) -o psjf $(PSJF_SRC)

round_robin:
	$(CC) -o round_robin $(ROUND_ROBIN_SRC)

mlfq:
	$(CC) -o mlfq $(MLFQ_SRC)

clean:
	rm -f $(TARGETS)

clean_psjf:
	rm -f psjf

clean_round_robin:
	rm -f round_robin

clean_mlfq:
	rm -f mlfq







