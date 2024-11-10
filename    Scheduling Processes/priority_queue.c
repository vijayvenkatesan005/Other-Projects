#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include "doubly_linked_list.h"

void priority_push(node_t * node, doubly_linked_list_t * processes_list) {
	if (is_empty(processes_list)) {
		push_r(node, processes_list);
	} else if (processes_list->length == 1) {
		if (node->process->burst_time <= processes_list->head->process->burst_time) {
			push_l(node, processes_list);
		} else {
			push_r(node, processes_list);
		}
	} else {
		node_t * current_node = processes_list->head;
		node_t * previous_node = NULL;
		node_t * temp;

		while (current_node != NULL && current_node->process->burst_time < node->process->burst_time) {
			previous_node = current_node;
			current_node = current_node->next;	
		}

		if (previous_node == NULL) {
			if (node->process->burst_time == processes_list->head->process->burst_time) {
				if (node->process->pid < processes_list->head->process->pid) {
					node->next = processes_list->head;
					processes_list->head->prev = node;
					processes_list->head = node;
				} else {
					temp = processes_list->head->next;
					processes_list->head->next = node;
					node->prev = processes_list->head;
					node->next = temp;
				}

			} else {
				temp = processes_list->head->next;
				processes_list->head->next = node;
				node->prev = processes_list->head;
				node->next = temp;

			}

		} else if (current_node == NULL) {
			previous_node->next = node;
			node->prev = previous_node;
		} else {
			if (node->process->burst_time == current_node->process->burst_time) {
				if (node->process->pid < current_node->process->pid) {
					temp = current_node;
					previous_node->next = node;
					node->prev = previous_node;
					node->next = temp;
				} else {
					temp = current_node->next;
					current_node->next = node;
					node->prev = current_node;
					node->next = temp;
				}
			} else {
				temp = previous_node->next;
				previous_node->next = node;
				node->prev = previous_node;
				node->next = temp;
			}

		}

		processes_list->length += 1;

	}

}


/**
int main() {

	doubly_linked_list_t * processes_list = create_list();
	
	process_t * process;
	node_t * node;

	process = create_process(24, 0, 1);
	node = create_node(process);

	priority_push(processes_list, node);
	print_dll(processes_list);

	printf("\n");

	process = create_process(3, 2, 2);
	node = create_node(process);

	priority_push(processes_list, node);
	print_dll(processes_list);

	printf("\n");

	process = create_process(3, 3, 3);
	node = create_node(process);

	priority_push(processes_list, node);
	print_dll(processes_list);

	printf("\n");

	process = create_process(21, 4, 4);
	node = create_node(process);

	priority_push(processes_list, node);
	print_dll(processes_list);

	printf("\n");

	process = create_process(21, 14, 5);
	node = create_node(process);

	priority_push(processes_list, node);
	print_dll(processes_list);

	printf("\n");

	process = create_process(31, 19, 6);
	node = create_node(process);

	priority_push(processes_list, node);
	print_dll(processes_list);

	printf("\n");


}
**/