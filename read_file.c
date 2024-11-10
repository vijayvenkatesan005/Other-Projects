#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "process.h"

process_t** parse_file(char* filename) {
	FILE * fp;
	// FILE * fopen(char * name, char * mode);

	fp = fopen(filename, "r");

	char buf[100];
	char s[100];

	int i = 0;
	int j = 0;
	int k = 0;

	int ch;
	char str[100];

	process_t** processes = (process_t**)malloc(sizeof(process_t*)*100);

	process_t* p = (process_t*)malloc(sizeof(process_t));


	while ((ch = getc(fp)) != EOF) {
		if (ch == ':') {
			if (j == 0) {
				str[i] = '\0';
				p->pid = atoi(str);
				memset(str, 0, sizeof(str));
				i = 0;
			} else if (j == 1) {
				str[i] = '\0';
				p->arrival_time = atoi(str);
				memset(str, 0, sizeof(str));
				i = 0;
			} else if (j == 2) {
				str[i] = '\0';
				p->burst_time = atoi(str);
				memset(str, 0, sizeof(str));
				i = 0;
			} else if (j == 3) {
				str[i] = '\0';
				p->priority = atoi(str);
				memset(str, 0, sizeof(str));
				i = 0;
			}
			j++;
			continue;
		}
		if (ch == '\n') {
			j = 0;
			processes[k++] = p;
			p = (process_t*)malloc(sizeof(process_t));
			i = 0;
			continue;
		}
		if (ch != '\n') {
			str[i++] = ch;	
		}
		
	}
	return processes;
}
