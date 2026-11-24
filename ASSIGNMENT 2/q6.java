import java.util.*;

public class q6 {
    static class Patient {
        final String name;
        final int severity;
        final long arrival;

        Patient(String name, int severity, long arrival) {
            this.name = name;
            this.severity = severity;
            this.arrival = arrival;
        }

        @Override
        public String toString() {
            return name + "(S" + severity + ")";
        }
    }

    private long counter = 0;
    private final PriorityQueue<Patient> queue = new PriorityQueue<>(
        Comparator.comparingInt((Patient p) -> p.severity)
                  .thenComparingLong(p -> p.arrival)
    );

    void admit(String name, int severity) {
        queue.add(new Patient(name, severity, counter++));
    }

    Patient next() {
        return queue.poll();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        q6 er = new q6();

        System.out.print("Enter number of patients: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter patient name: ");
            String name = sc.nextLine();
            System.out.print("Enter severity (1=critical to 5=minor): ");
            int severity = sc.nextInt();
            sc.nextLine();

            if (severity < 1 || severity > 5) {
                System.out.println("Invalid severity. Enter 1 to 5.");
                i--;
            } else {
                er.admit(name, severity);
            }
        }

        System.out.println("\nTreatment order:");
        Patient p;
        while ((p = er.next()) != null) {
            System.out.print(p + " ");
        }
        System.out.println();

        System.out.println("\nPriorityQueue uses O(log n) insertion and removal.");
        System.out.println("The arrival counter gives FIFO order for equal severity.");
        System.out.println("Aging can reduce starvation by improving priority for long-waiting patients.");
        sc.close();
    }
}
