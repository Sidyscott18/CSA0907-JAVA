import java.util.Scanner;

public class Task02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of floors: ");
        int floors = sc.nextInt();

        int[][] slots = new int[floors][];

        for (int i = 0; i < floors; i++) {
            System.out.print("Enter number of slots on floor " + i + ": ");
            int count = sc.nextInt();
            slots[i] = new int[count];
        }

        for (int i = 0; i < floors; i++) {
            System.out.println("Floor " + i + " has " + slots[i].length + " slots.");
        }

        System.out.print("Enter parking duration in minutes: ");
        int minutes = sc.nextInt();

        int hours = (minutes + 59) / 60; // rounds every started hour upward
        double rate = 30.0;
        double fee = hours * rate;

        System.out.println("Billable hours: " + hours);
        System.out.println("Parking fee: Rs " + fee);
        sc.close();
    }
}
