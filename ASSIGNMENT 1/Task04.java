import java.util.Scanner;

class ParkingTicket {
    int ticketNo;
    String regNo;

    ParkingTicket() {
        this(0, "Not Assigned");
    }

    ParkingTicket(int ticketNo, String regNo) {
        this.ticketNo = ticketNo;
        this.regNo = regNo;
    }

    void display() {
        System.out.println("Ticket Number: " + ticketNo);
        System.out.println("Vehicle Number: " + regNo);
    }
}

public class Task04 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter ticket number: ");
        int number = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter vehicle registration number: ");
        String reg = sc.nextLine();

        ParkingTicket ticket = new ParkingTicket(number, reg);
        ticket.display();
        sc.close();
    }
}
