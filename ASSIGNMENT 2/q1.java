import java.util.Scanner;

public class q1 {
    static String usingPlus(int tickets, int fields) {
        String result = "";
        for (int t = 0; t < tickets; t++) {
            String ticket = "";
            for (int f = 1; f <= fields; f++) {
                ticket = ticket + "Field" + f + " ";
            }
            result += ticket;
        }
        return result;
    }

    static String usingStringBuilder(int tickets, int fields) {
        StringBuilder result = new StringBuilder();
        for (int t = 0; t < tickets; t++) {
            StringBuilder ticket = new StringBuilder();
            for (int f = 1; f <= fields; f++) {
                ticket.append("Field").append(f).append(' ');
            }
            result.append(ticket);
        }
        return result.toString();
    }

    static String usingStringBuffer(int tickets, int fields) {
        StringBuffer result = new StringBuffer();
        for (int t = 0; t < tickets; t++) {
            StringBuffer ticket = new StringBuffer();
            for (int f = 1; f <= fields; f++) {
                ticket.append("Field").append(f).append(' ');
            }
            result.append(ticket);
        }
        return result.toString();
    }

    static long measure(int method, int tickets, int fields, int repeats) {
        long total = 0;
        for (int r = 0; r < repeats; r++) {
            long start = System.nanoTime();
            String output;
            if (method == 1) output = usingPlus(tickets, fields);
            else if (method == 2) output = usingStringBuilder(tickets, fields);
            else output = usingStringBuffer(tickets, fields);
            total += System.nanoTime() - start;
            // Keep the result observable so the work is not conceptually unused.
            if (output.length() == -1) System.out.println(output);
        }
        return total / repeats;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of tickets: ");
        int tickets = sc.nextInt();
        System.out.print("Enter number of fields per ticket: ");
        int fields = sc.nextInt();
        System.out.print("Enter number of repeated runs: ");
        int repeats = sc.nextInt();

        if (tickets < 1 || fields < 1 || repeats < 1) {
            System.out.println("Enter positive values only.");
            sc.close();
            return;
        }

        // Warm-up runs reduce some first-run JVM effects.
        usingPlus(1, Math.min(fields, 5));
        usingStringBuilder(1, Math.min(fields, 5));
        usingStringBuffer(1, Math.min(fields, 5));

        long plus = measure(1, tickets, fields, repeats);
        long builder = measure(2, tickets, fields, repeats);
        long buffer = measure(3, tickets, fields, repeats);

        System.out.println("\nAverage execution time:");
        System.out.println("String (+): " + plus + " ns");
        System.out.println("StringBuilder: " + builder + " ns");
        System.out.println("StringBuffer: " + buffer + " ns");
        System.out.println("\nEstimated intermediate objects:");
        System.out.println("String (+): many temporary String objects are created.");
        System.out.println("StringBuilder/StringBuffer: one mutable builder per ticket and result.");
        System.out.println("Recommendation: StringBuilder for a ticket built locally; StringBuffer");
        System.out.println("only when the same mutable buffer is genuinely shared between threads.");
        sc.close();
    }
}
