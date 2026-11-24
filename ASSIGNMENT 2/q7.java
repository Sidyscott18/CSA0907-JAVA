import java.util.Scanner;

public class q7 {
    // Original design: repeated String concatenation inside a loop.
    static String original(int tickets, int fields) {
        String allTickets = "";
        for (int t = 0; t < tickets; t++) {
            String ticket = "";
            for (int f = 1; f <= fields; f++) {
                ticket = ticket + "Field" + f + " ";
            }
            allTickets = allTickets + ticket;
        }
        return allTickets;
    }

    // Redesigned version: use one StringBuilder and append each field.
    static String redesigned(int tickets, int fields) {
        StringBuilder allTickets = new StringBuilder();
        for (int t = 0; t < tickets; t++) {
            for (int f = 1; f <= fields; f++) {
                allTickets.append("Field").append(f).append(' ');
            }
        }
        return allTickets.toString();
    }

    static long averageTime(boolean useBuilder, int tickets, int fields, int runs) {
        long total = 0;
        for (int r = 0; r < runs; r++) {
            long start = System.nanoTime();
            String result = useBuilder ? redesigned(tickets, fields) : original(tickets, fields);
            total += System.nanoTime() - start;
            if (result.length() == -1) System.out.println(result);
        }
        return total / runs;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of tickets: ");
        int tickets = sc.nextInt();
        System.out.print("Enter fields per ticket: ");
        int fields = sc.nextInt();
        System.out.print("Enter repeated runs: ");
        int runs = sc.nextInt();

        if (tickets < 1 || fields < 1 || runs < 1) {
            System.out.println("Enter positive values only.");
            sc.close();
            return;
        }

        // Small warm-up.
        original(1, Math.min(fields, 5));
        redesigned(1, Math.min(fields, 5));

        long oldTime = averageTime(false, tickets, fields, runs);
        long newTime = averageTime(true, tickets, fields, runs);

        System.out.println("\nOriginal String concatenation average: " + oldTime + " ns");
        System.out.println("Redesigned StringBuilder average: " + newTime + " ns");
        if (newTime < oldTime) {
            System.out.println("The redesigned version was faster in this run.");
        } else {
            System.out.println("The redesigned version was not faster in this run.");
        }

        System.out.println("\nDiagnosis: repeated concatenation creates temporary immutable Strings");
        System.out.println("and repeatedly copies existing characters.");
        System.out.println("Redesign: StringBuilder reuses a mutable character buffer.");
        System.out.println("Expected complexity: repeated concatenation can approach O(L^2)");
        System.out.println("for L output characters; StringBuilder append is amortized O(L).");
        System.out.println("Trade-off: StringBuilder uses a growable buffer and finally creates");
        System.out.println("the required immutable String. Results vary with JVM and machine load.");
        sc.close();
    }
}
