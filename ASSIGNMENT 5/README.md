# Assignment 5 - Java Programs

## Files
All files are directly in this ZIP. There are no task folders.

- `PassStore.java` - Add, find and list bus passes; skips damaged lines.
- `BufferedLineCounter.java` - Compare unbuffered and buffered file reading.
- `LoginSecurityDemo.java` - Compare unsafe SQL and PreparedStatement.
- `WalletTransaction.java` - Transfer money using commit and rollback.
- `StudentDaoDemo.java` - Generic DAO interface and StudentDao methods.
- `SerializationDemo.java` - Serialize and load a Hostel object.
- `PassLoader.java` - Batch insert in one transaction.
- `JdbcBenchmark.java` - Compare Statement, PreparedStatement and batch.
- `PassMigration.java` - Validate file rows, migrate and display database metadata.
- `assignment5_schema.sql` - Create the MySQL database and tables.

## Requirements
Install Java JDK. JDBC programs also need MySQL and MySQL Connector/J.

## Compile and run
Open Terminal or Command Prompt in this folder. Example:
```bash
javac PassStore.java
java PassStore
```
Use the same commands with the Java file name for other standalone programs.

## MySQL setup
1. Run `assignment5_schema.sql` in MySQL.
2. Replace `YOUR_MYSQL_PASSWORD` with your local MySQL password in JDBC files.
3. Put `mysql-connector-j.jar` in this folder.

Windows example:
```bash
javac -cp ".;mysql-connector-j.jar" LoginSecurityDemo.java
java -cp ".;mysql-connector-j.jar" LoginSecurityDemo
```
On Linux/macOS, use `:` instead of `;` in the classpath.

## Run
- `PassStore`: runs sample add/find/damaged-line tests.
- `BufferedLineCounter`: enter a text file path.
- `LoginSecurityDemo`: use the local test database only.
- `WalletTransaction`: transfers 500 between wallet IDs 1 and 2.
- `SerializationDemo`: creates `hostel.dat`.
- `JdbcBenchmark`: enter 1000, 10000 or 100000.
- `PassMigration`: run `java PassMigration passes.csv`.

## Important
- JDBC programs need a running MySQL server and Connector/J.
- The login table is for a local classroom demonstration only. Real applications must store secure password hashes, not plain-text passwords.
- Run the experiments yourself and record your own timing results. Do not invent measurements.
- The assignment also requires Part A pseudocode, record layouts, design explanations, screenshots, test evidence and analysis. Java files alone are not the complete report.
- Add your name, register number and Java version to your submission.
- Create the repository as `CSA09-<RegisterNumber>-Assignment5` and commit your work task by task.
