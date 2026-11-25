# Assignment 4 - Java Programs

## Files in this ZIP
All files are directly in this folder. There are no separate task folders.

- `Task1_FeePaymentApp.java` - Fee payment GUI and separate FeeService.
- `Task2_AppointmentDesk.java` - Hospital appointment form and event handlers.
- `Task3_LibrarySearchScreen.java` - Resizable library search screen.
- `Task4_DrawPad.java` - Mouse click counter; dots remain after repaint.
- `Task5_ConverterStyles.java` - Four listener styles and Enter-key conversion.
- `Task6_EventRegistrationApp.java` - Swing/JDBC registration, filtering, paging and CSV export.
- `Task6_schema.sql` - MySQL database setup.

## Requirements
Install Java JDK. Task 6 also needs MySQL and MySQL Connector/J.

## Compile and run
Open Terminal or Command Prompt in this folder. Example:

```bash
javac Task1_FeePaymentApp.java
java Task1_FeePaymentApp
```

Repeat using the required Java file name for each task.

## Task 6 setup
1. Run `Task6_schema.sql` in MySQL.
2. In `Task6_EventRegistrationApp.java`, set your MySQL username and password.
3. Add `mysql-connector-j.jar` to the classpath.

Windows:
```bash
javac -cp ".;mysql-connector-j.jar" Task6_EventRegistrationApp.java
java -cp ".;mysql-connector-j.jar" Task6_EventRegistrationApp
```

Linux/macOS: replace `;` with `:` in the classpath.

## Notes
- Tasks 1, 2 and 3 use sample/demo data. They are GUI demonstrations, not connected to real payment, hospital or library systems.
- Task 6 requires a running MySQL server and Connector/J.
- Run each program yourself. Add your name, register number, Java version, screenshots, test evidence, diagrams, pseudocode and comparisons to your report.
- Create your repository as `CSA09-<RegisterNumber>-Assignment4` and commit your work task by task.
