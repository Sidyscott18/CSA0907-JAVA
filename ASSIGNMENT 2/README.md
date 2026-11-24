# Assignment 2 – Java Programs (CO2)

This ZIP contains one standalone Java source file for each question: `q1.java` to `q7.java`.
All files are in one folder (no nested folders).

## Compile and run
Open a terminal in this folder and run one task at a time:

```bash
javac q1.java
java q1
```

Replace `q1` with `q2`, `q3`, ..., `q7` for the other tasks.

## Sample inputs

### Q1
```text
100
50
5
```
Meaning: 100 tickets, 50 fields per ticket, 5 repeated runs.

### Q2
```text
1000
10000
```
Meaning: playlist size 1000 and 10,000 indexed accesses. Repeat with 5000 and 10000 for multiple sizes.

### Q3
```text
3
192311001
Arun
192311002
Divya
192311001
Arun
```
Expected unique count: `2`.

### Q4
```text
3
MED101
25
MED102
40
MED103
15
MED102
```
TreeMap prints medicine codes in sorted order; LinkedHashMap prints insertion order.

### Q5
```text
4
Panthers
9
4
Eagles
9
6
Cobras
6
1
Bisons
9
4
```
Expected ranking:
`[Eagles(9,6), Bisons(9,4), Panthers(9,4), Cobras(6,1)]`

### Q6
```text
6
Ravi
3
Meena
1
John
3
Asha
5
Kumar
1
Lata
2
```
Expected treatment order:
`Meena(S1) Kumar(S1) Lata(S2) Ravi(S3) John(S3) Asha(S5)`

### Q7
```text
100
50
5
```
Meaning: compare 100 tickets with 50 fields, averaged over 5 runs.

## Important notes for the report

- Q1, Q2 and Q7 print measurements from the machine/JVM on which they are run. Do not copy invented timings into the report. Run each workload several times and record your own results.
- For Q1, try a small workload (1 ticket, 5 fields), a larger workload (10000 tickets, 50 fields), and one additional workload of your choice.
- For Q2, repeat with at least three playlist sizes. The program times several operations and includes an ArrayDeque double-ended queue example.
- Q3 demonstrates the corrected `equals()` and `hashCode()` contract. To perform the required “before correction” experiment, temporarily remove the `hashCode()` override and run the same duplicate scans; then restore it.
- Q4 demonstrates the three required map types. For a stronger experiment, add a repeated lookup loop (for example, 100000 lookups) and repeat with different inventory sizes.
- Q5 uses a generic `Leaderboard<T>` and an external Comparator so the ranking rule can be reused with other types.
- Q6 uses a PriorityQueue ordered by severity and arrival counter. A printed PriorityQueue is not guaranteed to display the full sorted treatment order; this program polls elements to show the actual order.
- Q7 is a redesign based on Q1: it compares repeated immutable String concatenation with StringBuilder. Use identical inputs and repeated runs. The assignment requires you to explain your diagnosis, objective, prediction, measured comparison and trade-offs in your report.
- Timing results are affected by JVM warm-up, garbage collection, computer load and hardware. Use repeated measurements and averages; do not treat one run as conclusive.
- The assignment also requires a GitHub repository named `CSA09-<RegisterNumber>-Assignment2`, progressive commits, screenshots, raw experimental data and a README with your own name/register number/Java version. Add those details before submission.
