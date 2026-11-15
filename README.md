# Data Structures (DS) - Assignment 02: Stack and Queue

- **Course:** Data Structures (DS)
- **Class / Section:** DS-3, Sections A & B
- **Student ID / Roll No:** 252-nun-0078
- **Student Name:** Muhammad Sian
- **Email:** 252-nun-0078@northern.edu.pk
- **University:** Northern University
- **Submission Date:** 16 November 2026
- **Repository:** [DSA-ASSIGNMENT-2](https://github.com/252-nun-0078-spec/DSA-ASSIGNMENT-2.git)

---

## Table of Contents
1. [Overview](#overview)
2. [Task and File Index](#task-and-file-index)
3. [Part 1: Stack](#part-1-stack)
   - [Question 1: Stack Implementation Using Array](#question-1-stack-implementation-using-array)
   - [Question 2: Stack Operations Trace & Final Analysis](#question-2-stack-operations-trace--final-analysis)
4. [Part 2: Queue](#part-2-queue)
   - [Question 3: Queue Implementation Using Array](#question-3-queue-implementation-using-array)
   - [Question 4: Queue Operations Trace & Final Analysis](#question-4-queue-operations-trace--final-analysis)
5. [Compilation and Execution Guide](#compilation-and-execution-guide)
6. [Sample Console Outputs](#sample-console-outputs)

---

## Overview

This repository contains the complete Java implementations, theoretical analyses, step-by-step traces, and state diagrams for **Assignment 02 (Stack and Queue, DS-3, Sections A & B)**. 

### Key Implementation Standards
- **Pure Java Implementation:** All data structures are built from scratch using primitive arrays (`int[]`) without relying on high-level collection frameworks (`java.util.Stack`, `java.util.Queue`, `ArrayList`, etc.).
- **Boundary & Exception Handling:** Strict boundary validation is enforced to detect and handle **Stack Overflow**, **Stack Underflow**, **Queue Overflow**, and **Queue Underflow**.
- **Dual Execution Modes:** Every program contains an automated test demonstration validating edge cases and normal workflows, alongside an interactive console menu.
- **Detailed Tracing:** Complete step-by-step state tracking is implemented both programmatically and documented with ASCII state diagrams.

---

## Task and File Index

| Question | File Name | Primary Class | Description | Time Complexity | Space Complexity |
| :--- | :--- | :--- | :--- | :---: | :---: |
| **Q1** | `Task01.java` / `StackArray.java` | `Task01` | Array-based Stack (Push, Pop, Peek, Display, Overflow & Underflow handling) | Push: $O(1)$<br>Pop: $O(1)$<br>Peek: $O(1)$<br>Display: $O(n)$ | $O(n)$ total<br>$O(1)$ auxiliary |
| **Q2** | `Task02.java` / `Q2_StackTrace.java` | `Task02` | Step-by-step trace of 6 Stack operations + final contents & top element | $O(1)$ per operation | $O(n)$ |
| **Q3** | `Task03.java` / `QueueArray.java` | `Task03` | Array-based Queue (Enqueue, Dequeue, Front, Display, Overflow & Underflow handling) | Enqueue: $O(1)$<br>Dequeue: $O(1)$<br>Front: $O(1)$<br>Display: $O(n)$ | $O(n)$ total<br>$O(1)$ auxiliary |
| **Q4** | `Task04.java` / `Q4_QueueTrace.java` | `Task04` | Step-by-step trace of 6 Queue operations + final contents & front element | $O(1)$ per operation | $O(n)$ |

---

## Part 1: Stack

### Question 1: Stack Implementation Using Array
**Requirements:**
Write a Java program to implement a Stack using an array performing the following operations:
- **Push:** Insert an element to the top.
- **Pop:** Remove and return the top element.
- **Peek:** Display the top element without removing it.
- **Display:** Display all elements from top to bottom.
- Handle **Stack Overflow** and **Stack Underflow** conditions.

#### Technical Design & Architecture
1. **Data Representation:**
   - `int[] stackArray`: Fixed-size array representing the stack memory.
   - `int top`: Integer pointer tracking the index of the uppermost element.
   - Initial state: `top = -1` (denoting an empty stack).
   - `int capacity`: Total maximum elements permitted in the stack.

2. **Operations & Boundary Logic:**
   - **Stack Overflow:** Occurs when trying to insert into an already full stack:
     $$\text{isFull()} \iff \text{top} == \text{capacity} - 1$$
     If true, `push()` rejects the element and displays an error message without modifying the array.
   - **Stack Underflow:** Occurs when attempting to remove or peek from an empty stack:
     $$\text{isEmpty()} \iff \text{top} == -1$$
     If true, `pop()` and `peek()` abort the request and display an underflow notification.
   - **Push Operation ($O(1)$):** Increments `top` pointer by $1$ and writes value into `stackArray[top]`.
   - **Pop Operation ($O(1)$):** Reads `stackArray[top]`, decrements `top` pointer by $1$, and returns the element.
   - **Peek Operation ($O(1)$):** Returns `stackArray[top]` without changing `top`.
   - **Display Operation ($O(n)$):** Iterates linearly backwards from `top` down to index $0$.

---

### Question 2: Stack Operations Trace & Final Analysis

**Problem Statement:**
Consider an initially empty Stack. Perform the following operations and show the Stack after each operation:
1. `Push(10)`
2. `Push(20)`
3. `Push(30)`
4. `Pop()`
5. `Push(40)`
6. `Pop()`

*What will be the final contents of the Stack, and what will be its top element?*

#### Step-by-Step State Diagrams

```
Initial State:
Empty Stack (top = -1)
  |        |
  +--------+

-----------------------------------------------------------
Step 1: Push(10)
Action: 10 inserted at index 0. top increments to 0.
  |   10   | <-- TOP (index 0)
  +--------+

-----------------------------------------------------------
Step 2: Push(20)
Action: 20 inserted at index 1. top increments to 1.
  |   20   | <-- TOP (index 1)
  |   10   |     (index 0)
  +--------+

-----------------------------------------------------------
Step 3: Push(30)
Action: 30 inserted at index 2. top increments to 2.
  |   30   | <-- TOP (index 2)
  |   20   |     (index 1)
  |   10   |     (index 0)
  +--------+

-----------------------------------------------------------
Step 4: Pop()
Action: Element at top (30) removed. top decrements to 1.
  |   20   | <-- TOP (index 1)
  |   10   |     (index 0)
  +--------+

-----------------------------------------------------------
Step 5: Push(40)
Action: 40 inserted at index 2. top increments to 2.
  |   40   | <-- TOP (index 2)
  |   20   |     (index 1)
  |   10   |     (index 0)
  +--------+

-----------------------------------------------------------
Step 6: Pop()
Action: Element at top (40) removed. top decrements to 1.
  |   20   | <-- TOP (index 1)
  |   10   |     (index 0)
  +--------+
```

#### Detailed Operations Trace Table

| Step | Operation | Value | Action Description | Stack Contents (Bottom $\to$ Top) | Top Index (`top`) | Top Element |
| :---: | :---: | :---: | :--- | :---: | :---: | :---: |
| **0** | *Initial* | — | Stack initialized as empty | `[]` | `-1` | None |
| **1** | `Push(10)` | 10 | Insert 10 at index 0 | `[10]` | `0` | **10** |
| **2** | `Push(20)` | 20 | Insert 20 at index 1 | `[10, 20]` | `1` | **20** |
| **3** | `Push(30)` | 30 | Insert 30 at index 2 | `[10, 20, 30]` | `2` | **30** |
| **4** | `Pop()` | 30 | Remove 30 from index 2 | `[10, 20]` | `1` | **20** |
| **5** | `Push(40)` | 40 | Insert 40 at index 2 | `[10, 20, 40]` | `2` | **40** |
| **6** | `Pop()` | 40 | Remove 40 from index 2 | `[10, 20]` | `1` | **20** |

#### Definitive Answers to Question 2:
1. **Final contents of the Stack:**
   - From Bottom to Top: **`[10, 20]`**
   - From Top to Bottom: **`[20, 10]`**
2. **Top element of the Stack:**
   - **`20`**

---

## Part 2: Queue

### Question 3: Queue Implementation Using Array
**Requirements:**
Write a Java program to implement a Queue using an array performing the following operations:
- **Enqueue:** Insert an element at the rear.
- **Dequeue:** Remove and return the front element.
- **Front:** Display the first element without removing it.
- **Display:** Display all elements from front to rear.
- Handle **Queue Overflow** and **Queue Underflow** conditions.

#### Technical Design & Architecture
1. **Data Representation:**
   - `int[] queueArray`: Fixed-size array storing elements.
   - `int front`: Points to the current front element.
   - `int rear`: Points to the current rear element.
   - `int count`: Tracks the current number of active elements.
   - `int capacity`: Total maximum elements permitted in the queue.

2. **Circular Wrapping Strategy (Preventing False Overflow):**
   - In a simple linear queue, when elements are dequeued, the vacated spaces at the front cannot be reused, resulting in **false overflow** even when the array has empty cells.
   - To eliminate false overflow, this implementation uses modular arithmetic wrapping:
     $$\text{rear} = (\text{rear} + 1) \pmod{\text{capacity}}$$
     $$\text{front} = (\text{front} + 1) \pmod{\text{capacity}}$$

3. **Operations & Boundary Logic:**
   - **Queue Overflow:**
     $$\text{isFull()} \iff \text{count} == \text{capacity}$$
     If true, `enqueue()` rejects the incoming element and prints an overflow warning.
   - **Queue Underflow:**
     $$\text{isEmpty()} \iff \text{count} == 0$$
     If true, `dequeue()` and `front()` reject the operation and notify the user.
   - **Enqueue Operation ($O(1)$):** Advances `rear` cyclically, writes value to `queueArray[rear]`, and increments `count`.
   - **Dequeue Operation ($O(1)$):** Reads `queueArray[front]`, advances `front` cyclically, and decrements `count`.
   - **Front Operation ($O(1)$):** Returns `queueArray[front]`.
   - **Display Operation ($O(n)$):** Traverses $i$ from $0$ to $\text{count} - 1$, accessing indices via $(\text{front} + i) \pmod{\text{capacity}}$.

---

### Question 4: Queue Operations Trace & Final Analysis

**Problem Statement:**
Consider an initially empty Queue. Perform the following operations and show the Queue after each operation:
1. `Enqueue(10)`
2. `Enqueue(20)`
3. `Enqueue(30)`
4. `Dequeue()`
5. `Enqueue(40)`
6. `Dequeue()`

*What will be the final contents of the Queue, and what will be its front element?*

#### Step-by-Step State Diagrams

```
Initial State:
Empty Queue (count = 0)
  FRONT -> [ Empty Queue ] <- REAR

-----------------------------------------------------------
Step 1: Enqueue(10)
Action: 10 inserted at rear.
  FRONT -> [ 10 ] <- REAR

-----------------------------------------------------------
Step 2: Enqueue(20)
Action: 20 inserted at rear.
  FRONT -> [ 10 ] -> [ 20 ] <- REAR

-----------------------------------------------------------
Step 3: Enqueue(30)
Action: 30 inserted at rear.
  FRONT -> [ 10 ] -> [ 20 ] -> [ 30 ] <- REAR

-----------------------------------------------------------
Step 4: Dequeue()
Action: Front element (10) removed.
  FRONT -> [ 20 ] -> [ 30 ] <- REAR

-----------------------------------------------------------
Step 5: Enqueue(40)
Action: 40 inserted at rear.
  FRONT -> [ 20 ] -> [ 30 ] -> [ 40 ] <- REAR

-----------------------------------------------------------
Step 6: Dequeue()
Action: Front element (20) removed.
  FRONT -> [ 30 ] -> [ 40 ] <- REAR
```

#### Detailed Operations Trace Table

| Step | Operation | Value | Action Description | Queue Contents (Front $\to$ Rear) | Front Element | Rear Element | Queue Size |
| :---: | :---: | :---: | :--- | :---: | :---: | :---: | :---: |
| **0** | *Initial* | — | Queue initialized as empty | `[]` | None | None | 0 |
| **1** | `Enqueue(10)` | 10 | Insert 10 at rear | `[10]` | **10** | **10** | 1 |
| **2** | `Enqueue(20)` | 20 | Insert 20 at rear | `[10, 20]` | **10** | **20** | 2 |
| **3** | `Enqueue(30)` | 30 | Insert 30 at rear | `[10, 20, 30]` | **10** | **30** | 3 |
| **4** | `Dequeue()` | 10 | Remove 10 from front | `[20, 30]` | **20** | **30** | 2 |
| **5** | `Enqueue(40)` | 40 | Insert 40 at rear | `[20, 30, 40]` | **20** | **40** | 3 |
| **6** | `Dequeue()` | 20 | Remove 20 from front | `[30, 40]` | **30** | **40** | 2 |

#### Definitive Answers to Question 4:
1. **Final contents of the Queue:**
   - From Front to Rear: **`[30, 40]`**
2. **Front element of the Queue:**
   - **`30`** (and Rear element is **`40`**)

---

## Compilation and Execution Guide

All files can be compiled and executed directly from the terminal or command prompt using standard Java commands.

### 1. Compile All Files
```bash
javac *.java
```

### 2. Execute Specific Tasks
- **To run Question 1 (Stack Implementation):**
  ```bash
  java Task01
  # OR
  java StackArray
  # OR
  java Q1_Stack
  ```

- **To run Question 2 (Stack Operations Trace):**
  ```bash
  java Task02
  # OR
  java Q2_StackTrace
  ```

- **To run Question 3 (Queue Implementation):**
  ```bash
  java Task03
  # OR
  java QueueArray
  # OR
  java Q3_Queue
  ```

- **To run Question 4 (Queue Operations Trace):**
  ```bash
  java Task04
  # OR
  java Q4_QueueTrace
  ```

---

## Sample Console Outputs

### Output for `Task02` (Q2 Trace)
```
===============================================================
  Q2: Stack Operations Trace & Final Analysis
===============================================================
Initial State: Initially Empty Stack (top = -1)

     |        | (Empty)
     +--------+

---------------------------------------------------------------
Step 1: Perform Operation -> Push(10)
Action: Inserted 10 at top index (0)
Stack Contents (Bottom -> Top): [10]
Current Top Element: 10
Visual State:
     |    10  | <-- TOP (index 0)
     +--------+ (Bottom)

---------------------------------------------------------------
Step 2: Perform Operation -> Push(20)
Action: Inserted 20 at top index (1)
Stack Contents (Bottom -> Top): [10, 20]
Current Top Element: 20
Visual State:
     |    20  | <-- TOP (index 1)
     |    10  |     (index 0)
     +--------+ (Bottom)

---------------------------------------------------------------
Step 3: Perform Operation -> Push(30)
Action: Inserted 30 at top index (2)
Stack Contents (Bottom -> Top): [10, 20, 30]
Current Top Element: 30
Visual State:
     |    30  | <-- TOP (index 2)
     |    20  |     (index 1)
     |    10  |     (index 0)
     +--------+ (Bottom)

---------------------------------------------------------------
Step 4: Perform Operation -> Pop()
Action: Removed top element (30)
Stack Contents (Bottom -> Top): [10, 20]
Current Top Element: 20
Visual State:
     |    20  | <-- TOP (index 1)
     |    10  |     (index 0)
     +--------+ (Bottom)

---------------------------------------------------------------
Step 5: Perform Operation -> Push(40)
Action: Inserted 40 at top index (2)
Stack Contents (Bottom -> Top): [10, 20, 40]
Current Top Element: 40
Visual State:
     |    40  | <-- TOP (index 2)
     |    20  |     (index 1)
     |    10  |     (index 0)
     +--------+ (Bottom)

---------------------------------------------------------------
Step 6: Perform Operation -> Pop()
Action: Removed top element (40)
Stack Contents (Bottom -> Top): [10, 20]
Current Top Element: 20
Visual State:
     |    20  | <-- TOP (index 1)
     |    10  |     (index 0)
     +--------+ (Bottom)

===============================================================
                       FINAL SUMMARY & ANSWERS                 
===============================================================
Operations Performed Summary Table:
+------+------------+--------------------+-----------+-------------+
| Step | Operation  | Element Affected   | Top Index | Top Element |
+------+------------+--------------------+-----------+-------------+
|  1   | Push(10)   | Inserted 10        |     0     |     10      |
|  2   | Push(20)   | Inserted 20        |     1     |     20      |
|  3   | Push(30)   | Inserted 30        |     2     |     30      |
|  4   | Pop()      | Removed 30         |     1     |     20      |
|  5   | Push(40)   | Inserted 40        |     2     |     40      |
|  6   | Pop()      | Removed 40         |     1     |     20      |
+------+------------+--------------------+-----------+-------------+

>>> Answers to Assignment Questions:
1. What will be the final contents of the Stack?
   -> Final contents (Bottom to Top): [10, 20]
   -> Final contents (Top to Bottom): [20, 10]
2. What will be its top element?
   -> Top element is: 20
===============================================================
```

### Output for `Task04` (Q4 Trace)
```
===============================================================
  Q4: Queue Operations Trace & Final Analysis
===============================================================
Initial State: Initially Empty Queue (size = 0)

     FRONT -> [ Empty Queue ] <- REAR

---------------------------------------------------------------
Step 1: Perform Operation -> Enqueue(10)
Action: Inserted 10 at Rear
Queue Contents (Front -> Rear): [10]
Front Element: 10 | Rear Element: 10
Visual State:
     FRONT -> [ 10 ] <- REAR

---------------------------------------------------------------
Step 2: Perform Operation -> Enqueue(20)
Action: Inserted 20 at Rear
Queue Contents (Front -> Rear): [10, 20]
Front Element: 10 | Rear Element: 20
Visual State:
     FRONT -> [ 10 ] -> [ 20 ] <- REAR

---------------------------------------------------------------
Step 3: Perform Operation -> Enqueue(30)
Action: Inserted 30 at Rear
Queue Contents (Front -> Rear): [10, 20, 30]
Front Element: 10 | Rear Element: 30
Visual State:
     FRONT -> [ 10 ] -> [ 20 ] -> [ 30 ] <- REAR

---------------------------------------------------------------
Step 4: Dequeue()
Action: Removed Front element (10)
Queue Contents (Front -> Rear): [20, 30]
Front Element: 20 | Rear Element: 30
Visual State:
     FRONT -> [ 20 ] -> [ 30 ] <- REAR

---------------------------------------------------------------
Step 5: Perform Operation -> Enqueue(40)
Action: Inserted 40 at Rear
Queue Contents (Front -> Rear): [20, 30, 40]
Front Element: 20 | Rear Element: 40
Visual State:
     FRONT -> [ 20 ] -> [ 30 ] -> [ 40 ] <- REAR

---------------------------------------------------------------
Step 6: Dequeue()
Action: Removed Front element (20)
Queue Contents (Front -> Rear): [30, 40]
Front Element: 30 | Rear Element: 40
Visual State:
     FRONT -> [ 30 ] -> [ 40 ] <- REAR

===============================================================
                       FINAL SUMMARY & ANSWERS                 
===============================================================
Operations Performed Summary Table:
+------+---------------+--------------------+---------------+---------------+
| Step | Operation     | Element Affected   | Front Element | Rear Element  |
+------+---------------+--------------------+---------------+---------------+
|  1   | Enqueue(10)   | Inserted 10        |      10       |      10       |
|  2   | Enqueue(20)   | Inserted 20        |      10       |      20       |
|  3   | Enqueue(30)   | Inserted 30        |      10       |      30       |
|  4   | Dequeue()     | Removed 10         |      20       |      30       |
|  5   | Enqueue(40)   | Inserted 40        |      20       |      40       |
|  6   | Dequeue()     | Removed 20         |      30       |      40       |
+------+---------------+--------------------+---------------+---------------+

>>> Answers to Assignment Questions:
1. What will be the final contents of the Queue?
   -> Final contents (Front to Rear): [30, 40]
2. What will be its front element?
   -> Front element is: 30
   -> Rear element is:  40
===============================================================
```

---

## Submission Form Link
Per assignment instructions, after completing the repository upload, submit your link at:
[Assignment 02 Online Submission Form](https://docs.google.com/forms/d/e/1FAIpQLSfB9k14wkMhyqAvTrFFNTuOgRORa8-1sHvIRdV-ihnkRlAzDQ/viewform?usp=publish-editor)
