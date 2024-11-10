#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>
#include "doubly_linked_list.h"

node_t* create_node(process_t* process) {
  node_t* node = (node_t*)malloc(sizeof(node_t));
  node->process = process;
  node->next = NULL;
  node->prev = NULL;
  return node;
}

void free_node(node_t* node) {
  free(node);
}

doubly_linked_list_t* create_list(int timeslice) {
  // Maybe remove the 1000 later
  doubly_linked_list_t* dll = (doubly_linked_list_t*)malloc(sizeof(doubly_linked_list_t)*1000);
  dll->head = NULL;
  dll->tail = NULL;
  dll->length = 0;
  dll->timeslice = timeslice;
  return dll;
}

void free_list(doubly_linked_list_t* dll) {
  free(dll);
}

bool is_empty(doubly_linked_list_t* dll) {
  return dll->length == 0;
}

void push_l(node_t* node, doubly_linked_list_t* dll) {
  if (is_empty(dll)) {
    dll->head = node;
    dll->tail = node;
  } else if (dll->length == 1) {
    dll->head = node;
    node->next = dll->tail;
    dll->tail->prev = dll->head;
    dll->head->prev = NULL;
    dll->tail->next = NULL;
  } else {
    dll->head->prev = node;
    node->next = dll->head;
    dll->head = node;
    dll->head->prev = NULL;
    dll->tail->next = NULL;
  }
  dll->length += 1;
}

void push_r(node_t* node, doubly_linked_list_t* dll) {
  if (is_empty(dll)) {
    dll->head = node;
    dll->tail = node;
  } else if (dll->length == 1) {
    dll->tail = node;
    node->prev = dll->head;
    dll->head->next = dll->tail;
    dll->tail->next = NULL;
    dll->head->prev = NULL;
  } else {
    dll->tail->next = node;
    node->prev = dll->tail;
    dll->tail = node;
    dll->tail->next = NULL;
    dll->head->prev = NULL;
  }
  dll->length += 1;
}

node_t* pop_l(doubly_linked_list_t* dll) {
  if (is_empty(dll)) {
    printf("Cannot pop from empty list\n");
    return NULL;
  }
  node_t* temp = dll->head;
  if (dll->length == 1) {
    dll->head = NULL;
    dll->tail = NULL;
  } else if (dll->length == 2) {
    dll->head = dll->tail;
    dll->head->next = NULL;
    dll->tail->next = NULL;
    dll->head->prev = NULL;
    dll->tail->prev = NULL;
  } else {
    dll->head = dll->head->next;
    temp->next = NULL;
    temp->prev = NULL;
    dll->head->prev = NULL;
  }
  dll->length -= 1;
  return temp;
}

node_t* pop_r(doubly_linked_list_t* dll) {
  if (is_empty(dll)) {
    printf("Cannot pop from empty list\n");
    return NULL;
  }
  node_t* temp = dll->tail;
  if (dll->length == 1) {
    dll->head = NULL;
    dll->tail = NULL;
  } else if (dll->length == 2) {
    dll->tail = dll->head;
    dll->head->next = NULL;
    dll->tail->next = NULL;
    dll->head->prev = NULL;
    dll->tail->prev = NULL;
  } else {
    dll->tail = dll->tail->prev;
    temp->prev = NULL;
    temp->next = NULL;
    dll->tail->next = NULL;
  }
  dll->length -= 1;
  return temp;
}

node_t* pop_m(node_t* node_to_remove, doubly_linked_list_t* dll) {
  if (node_to_remove == dll->head) {
    node_to_remove = pop_l(dll);
    node_to_remove->next = NULL;
    node_to_remove->prev = NULL;
    return node_to_remove;
  } else if (node_to_remove == dll->tail) {
    node_to_remove = pop_r(dll);
    node_to_remove->prev = NULL;
    node_to_remove->next = NULL;
    return node_to_remove;
  }
  node_t* curr = (node_t*)malloc(sizeof(node_t));
  curr = dll->head;
  while (curr != NULL && curr != node_to_remove) {
    curr = curr->next;
  }
  if (curr != NULL) {
    curr->prev->next = curr->next;
    curr->next->prev = curr->prev;
    curr->next = NULL;
    curr->prev = NULL;
    node_to_remove = curr;
    dll->length -= 1;
  }
  return node_to_remove;
}

void print_dll(doubly_linked_list_t* dll) {
  if (is_empty(dll)) {
    printf("***************\n");
    printf("Head: NULL\n");
    printf("Tail: NULL\n");
    printf("List is empty\n");
    printf("***************\n");
    return;
  }
  node_t* temp = dll->head;
  printf("<-- List head and tail -->\n");
  printf("***************\n");
  printf("Head: %d\n", dll->head->process->pid);
  printf("Tail: %d\n", dll->tail->process->pid);
  printf("Length: %d\n", dll->length);
  printf("***************\n");
  printf("<-- Start of list -->\n");
  printf("===============");
  if (dll->head == NULL) {
    printf(">>>The list is empty<<<\n");
  }
  while (temp != NULL) {
    printf("\n");
    printf("Process pid: ");
    printf("%d", temp->process->pid);
    printf("\n");
    printf("Burst time: ");
    printf("%d", temp->process->burst_time);
    printf("\n");
    printf("Arrival time: ");
    printf("%d", temp->process->arrival_time);
    printf("\n");
    printf("Requesting IO: ");
    printf("%d", temp->process->requesting_IO);
    printf("\n");
    if (temp->prev != NULL) {
      printf("Prev: ");
      printf("%d", temp->prev->process->pid);
      printf("\n");
    } else {
      printf("Prev: NULL\n");
    }
    if (temp->next != NULL) {
      printf("Next: ");
      printf("%d", temp->next->process->pid);
      printf("\n");
    } else {
      printf("Next: NULL\n");
    }
    printf("===============");
    temp = temp->next;
  }
  printf("\n<-- End of list -->\n");
}
