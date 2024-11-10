#ifndef doubly_linked_list
#endif

#include "process.h"

typedef struct node {
  process_t* process;
  struct node* prev;
  struct node* next;
} node_t;

typedef struct doubly_linked_list {
  node_t* head;
  node_t* tail;
  int length;
  int timeslice;
} doubly_linked_list_t;

node_t* create_node(process_t* process);
bool is_empty(doubly_linked_list_t* dll);
void free_node(node_t* node);
doubly_linked_list_t* create_list();
void free_list(doubly_linked_list_t* dll);
void push_l(node_t* node, doubly_linked_list_t* dll);
void push_r(node_t* node, doubly_linked_list_t* dll);
node_t* pop_l(doubly_linked_list_t* dll);
node_t* pop_r(doubly_linked_list_t* dll);
node_t* pop_m(node_t* node_to_remove, doubly_linked_list_t* dll);
void print_dll(doubly_linked_list_t* dll);
