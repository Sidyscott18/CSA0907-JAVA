import java.util.Scanner;

interface Chargeable {
    double chargingFee(int units);
}

abstract class Vehicle {
    String regNo;

    Vehicle(String regNo) {
        this.regNo = regNo;
    }

    abstract double calculateFee(int hours);
}

class ElectricCar extends Vehicle implements Chargeable {
    ElectricCar(String regNo) {
        super(regNo);
    }

    double calculateFee(int hours) {
        return hours * 30.0;
    }

    public double chargingFee(int units) {
        return units * 12.0;
    }
}

public class Task09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter electric car registration: ");
        String reg = sc.nextLine();

        System.out.print("Enter parking hours: ");
        int hours = sc.nextInt();

        System.out.print("Enter charging units: ");
        int units = sc.nextInt();

        ElectricCar car = new ElectricCar(reg);
        double total = car.calculateFee(hours) + car.chargingFee(units);

        System.out.println("Parking fee: Rs " + car.calculateFee(hours));
        System.out.println("Charging fee: Rs " + car.chargingFee(units));
        System.out.println("Total fee: Rs " + total);
        sc.close();
    }
}
