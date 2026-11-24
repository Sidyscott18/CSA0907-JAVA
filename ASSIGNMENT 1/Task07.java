import java.util.Scanner;

class Vehicle {
    String regNo;

    Vehicle(String regNo) {
        this.regNo = regNo;
    }

    double calculateFee(int hours) {
        return hours * 10.0;
    }

    @Override
    public String toString() {
        return "Vehicle Registration: " + regNo;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Vehicle) {
            Vehicle other = (Vehicle) obj;
            return regNo.equals(other.regNo);
        }
        return false;
    }

    @Override
    public int hashCode() {
        return regNo.hashCode();
    }
}

class Car extends Vehicle {
    Car(String regNo) {
        super(regNo);
    }

    @Override
    double calculateFee(int hours) {
        return hours * 30.0;
    }
}

public class Task07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter car registration number: ");
        String reg = sc.nextLine();

        System.out.print("Enter parking hours: ");
        int hours = sc.nextInt();

        Vehicle v = new Car(reg);
        System.out.println(v);
        System.out.println("Parking fee: Rs " + v.calculateFee(hours));
        sc.close();
    }
}
