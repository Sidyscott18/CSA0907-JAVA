import java.util.Scanner;

abstract class Vehicle {
    String regNo;

    Vehicle(String regNo) {
        this.regNo = regNo;
    }

    abstract double calculateFee(int hours, int startHour);
}

class Car extends Vehicle {
    Car(String regNo) { super(regNo); }

    double calculateFee(int hours, int startHour) {
        return hours * 30.0;
    }
}

class EBike extends Vehicle {
    EBike(String regNo) { super(regNo); }

    double calculateFee(int hours, int startHour) {
        return 20.0; // flat fee
    }
}

class DeliveryVan extends Vehicle {
    DeliveryVan(String regNo) { super(regNo); }

    double calculateFee(int hours, int startHour) {
        double rate = (startHour >= 9 && startHour < 17) ? 60.0 : 30.0;
        return hours * rate;
    }
}

public class Task12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter vehicle type (car/ebike/van): ");
        String type = sc.nextLine();

        System.out.print("Enter registration number: ");
        String reg = sc.nextLine();

        System.out.print("Enter parking duration in hours: ");
        int hours = sc.nextInt();

        System.out.print("Enter entry hour (0-23): ");
        int startHour = sc.nextInt();

        System.out.print("Is the visitor using a one-day pass? (true/false): ");
        boolean pass = sc.nextBoolean();

        Vehicle v;
        if (type.equalsIgnoreCase("ebike")) {
            v = new EBike(reg);
        } else if (type.equalsIgnoreCase("van")) {
            v = new DeliveryVan(reg);
        } else {
            v = new Car(reg);
        }

        double fee = pass ? 0.0 : v.calculateFee(hours, startHour);
        System.out.println("Vehicle: " + v.regNo);
        System.out.println("Parking fee: Rs " + fee);
        sc.close();
    }
}
