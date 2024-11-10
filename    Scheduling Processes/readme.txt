##############################################################
#                                                            #
#             Yue-Venkatesan Scheduler Suite                 #
# An optimal scheduler package for all your scheduling needs #
#                                                            #
##############################################################

Project 2

###############
#Group Members#
###############

Richard Yue, Vijay Venkatesan

##################
#Project Overview#
##################

The Yue-Venkatesan Scheduling Suite offers a scheduling package
written in the standard C library for all your scheduling needs.
The scheduling algorithms included are:

- Preemptive Shortest Job First (PSJF)
- Round Robin
- Multilevel Feedback Queue (MLFQ)

#################
#Key assumptions#
#################

We assume you have access to a terminal program. Bash, zsh, or
the Windows Subsystem for Linux should work fine. Ensure you have
gcc installed.

Each file has a program with its corresponding name. For example,
to run the MLFQ algorithm with an input file, you will need to
first build the mlfq file with make, then run it with your
favorite input file.

Input files must be colon-separated in the following format:

PID:arrival_time:service_time:priority

One example is:
123:0:15:1
124:1:16:2
...

Please ensure your input file uses the Unix linebreak ('\n')
and not carriage returns ('\r') or MS-DOS linebreaks ('^M').

###################
#Work distribution#
###################

Richard Yue wrote the following files himself:

round_robin_main.c
round_robin_main.h
doubly_linked_list.c
doubly_linked_list.h
coordinator.h

Vijay Venkatesan wrote the following files himself:

priority_queue.c
priority_queue.h
psjf_main.c

The following files were mostly written through pair
programming as a team, with one person writing
code and one person looking for errors and
searching for syntax on the side. Every once
in a while, maybe every hour or so, a switch
in roles occurred.

coordinator.c
mlfq_main.c

################
#Building Files#
################

From the program directory, run `make *program*` to build
the desired program. For example, to build MLFQ, you can run
`make mlfq`.

Your options are:
1. make psjf
2. make round_robin
2. make mlfq

###################
#Running a Program#
###################

The simulation programs require an input file containing the
job descriptions. The input file must be passed in as a
command line argument when running the program. For example,
from your favorite terminal, you can run: `mlfq input.txt`,
passing in the input file as argument 1 to the program.

###################
#File descriptions#
###################

Curious users will find a description of what is contained
in each file below:

1. coordinator.c

This file contains all that is needed to run a simulation.
Namely, it allows for processes to be printed to the
terminal (or redirected to a file from stdout). It also
takes care of creating and managing queues (doubly linked
lists).

2. doubly_linked_list.c

This file contains the definitions needed to create and
manipulate doubly linked list structs. It is possible
to create a list, push to the left or right, and pop
from the left, right, or middle.

3. priority_queue.c

This file contains additional definitions for managing
a priority queue. From a created doubly linked list,
jobs can be added to their corresponding position
in the queue based on remaining burst time (for use
with PSJF)

4. process.c

This file contains all the definitions needed to work
with processes. These form the backbone of all the
algorithms, since processes need to be queued,
dequeued, run, and managed.

5. psjf_main.c

This file contains code for running a preemptive
shortest job first simulation.

6. round_robin_main.c

This file contains code for running a round robin
simulation.

7. mlfq_main.c

This file contains code for running a multi-level
feedback queue simulation.

##############
#Header files#
##############

All files that do not end in _main have their own
header files (for example coordinator.h), which
contains struct and typedef definitions as well
as function signatures.

##################################
#Algorithm testing and validation#
##################################

We tested each program with a small subset of jobs
seeing if jobs were scheduled in the right order
given the algorithm's specifications. For
round robin, we checked if the jobs alternated and
if I/O wait and ready times were changed correctly.
We also checked if burst times were modified after
each iteration. We thoroughly tested the queues
by printing the queue after each operation. For
multilevel feedback queue, we tested using debugging
info such as how many jobs were in each queue. We
also took care to ensure that algorithms terminated
and that I/O started and stopped by providing this
info directly during execution.

############
#Disclaimer#
############

Use at your own risk. Not responsible for damage
done to equipment through use of this program
and/or crashes and/or freezes.

***************************
*Enjoy using the software!*
***************************

Go Huskies!

            |\
   \`-. _.._| \
    |_,'  __`. \
    (.\ _/.| _  |
   ,'      __ \ |
 ,'     __/||\  |
(Y8P  ,/|||||/  |
   `-'_----    /
      /`-._.-'/
      `-.__.-' 
