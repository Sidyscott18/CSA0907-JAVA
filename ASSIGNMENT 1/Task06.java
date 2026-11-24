import java.util.Scanner;

class Vehicle {
    String regNo;

    Vehicle(String regNo) {
        this.regNo = regNo;
        System.out.println("Vehicle constructor");
    }
}

class Car extends Vehicle {
    Car(String regNo) {
        super(regNo);
        System.out.println("Car constructor");
    }
}

class ElectricCar extends Car {
    ElectricCar(String regNo) {
        super(regNo);
        System.out.println("ElectricCar constructor");
    }
}

public class Task06 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter electric car registration number: ");
        String reg = sc.nextLine();

        ElectricCar e = new ElectricCar(reg);
        System.out.println("Registered vehicle: " + e.regNo);
        sc.close();
    }
}
