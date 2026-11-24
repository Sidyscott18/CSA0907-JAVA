import java.util.Scanner;

interface Chargeable {
    double chargingFee(int kWh);
}

abstract class Vehicle {
    private final String regNo;

    Vehicle(String regNo) {
        this.regNo = regNo;
    }

    public String getRegNo() {
        return regNo;
    }

    protected abstract double ratePerHour();

    public double calculateFee(int minutes) {
        int hours = (minutes + 59) / 60;
        return hours * ratePerHour();
    }
}

class TwoWheeler extends Vehicle {
    TwoWheeler(String regNo) { super(regNo); }
    protected double ratePerHour() { return 10; }
}

class Car extends Vehicle {
    Car(String regNo) { super(regNo); }
    protected double ratePerHour() { return 30; }
}

class ElectricCar extends Car implements Chargeable {
    ElectricCar(String regNo) { super(regNo); }
    public double chargingFee(int kWh) { return kWh * 12; }
}

public class Task08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Vehicle[] parked = new Vehicle[3];

        System.out.print("Enter two-wheeler registration: ");
        parked[0] = new TwoWheeler(sc.nextLine());

        System.out.print("Enter car registration: ");
        parked[1] = new Car(sc.nextLine());

        System.out.print("Enter electric car registration: ");
        parked[2] = new ElectricCar(sc.nextLine());

        System.out.print("Enter parking duration in minutes: ");
        int minutes = sc.nextInt();

        System.out.print("Enter EV charging units (kWh): ");
        int units = sc.nextInt();

        for (Vehicle v : parked) {
            double fee = v.calculateFee(minutes);
            if (v instanceof Chargeable) {
                fee += ((Chargeable) v).chargingFee(units);
            }
            System.out.println(v.getClass().getSimpleName() + " " +
                    v.getRegNo() + " -> Rs " + fee);
        }
        sc.close();
    }
}
