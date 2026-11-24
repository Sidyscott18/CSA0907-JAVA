import java.util.Scanner;

class Ticket {
    static int count = 0;
    int ticketNo;
    String regNo;

    Ticket(String regNo) {
        count++;
        ticketNo = count;
        this.regNo = regNo;
    }

    void display() {
        System.out.println("Ticket: " + ticketNo + " Vehicle: " + regNo);
    }
}

public class Task05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of vehicles: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter registration number: ");
            String reg = sc.nextLine();
            Ticket t = new Ticket(reg);
            t.display();
        }

        System.out.println("Total tickets issued: " + Ticket.count);
        sc.close();
    }
}
