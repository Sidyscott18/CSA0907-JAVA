# Assignment 3 - Java Programs

## Folders
- Task01: ATM exception handling
- Task02: User-defined exception and exception chaining
- Task03: File handling with try-with-resources
- Task04: Thread creation and life cycle
- Task05: Synchronized cinema seat booking
- Task06: Producer-consumer using wait() and notifyAll()
- Task07: Concurrent result processing with ExecutorService

## Requirements
Install Java JDK. Open Command Prompt or Terminal in the required task folder.

## Compile and run
Example for Task01:
```bash
cd Task01
javac ATMExceptionDemo.java
java ATMExceptionDemo
```
For other tasks, enter that task folder and use its Java file name with `javac` and `java`.

## Sample inputs
- Task01: account number, balance, withdrawal amount. Example: 12345, 5000, 1000
- Task02: file name and size in KB. Example: answer.pdf, 800
- Task03: number of store files. Example: 3
- Task05: seats and users. Example: 10, 100
- Task06: number of tokens. Example: 20
- Task07: number of files, pool size, then each file value. Enter a mark, C for corrupt, or M for missing. Example: 4, 2, 75, C, M, 32

Task04 starts four scanner threads automatically.

## Check the results
- Task02: a file over 500 KB displays the error and original cause.
- Task05: seats sold must not exceed the number of seats.
- Task06: collected sum must match the expected sum.
- Task07: processing continues even if a file is missing or corrupt.

Run every program yourself. Save your own screenshots, test tables, stack traces and timing results. Do not use made-up measurements. Add your name, register number and Java version to your final submission.

Create the repository as `CSA09-<RegisterNumber>-Assignment3`. Keep each task in its folder and commit your work task by task.
