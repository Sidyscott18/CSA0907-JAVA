import java.util.Scanner;

class ParkingFacility {
    private final String[][] slots;

    ParkingFacility(int[] slotsPerFloor) {
        slots = new String[slotsPerFloor.length][];
        for (int f = 0; f < slotsPerFloor.length; f++) {
            slots[f] = new String[slotsPerFloor[f]];
        }
    }

    public int[] allocate(String vehicleNo) {
        for (int f = 0; f < slots.length; f++) {
            for (int s = 0; s < slots[f].length; s++) {
                if (slots[f][s] == null) {
                    slots[f][s] = vehicleNo;
                    return new int[]{f, s};
                }
            }
        }
        return null;
    }

    public boolean release(int floor, int slot) {
        if (floor < 0 || floor >= slots.length) return false;
        if (slot < 0 || slot >= slots[floor].length) return false;
        if (slots[floor][slot] == null) return false;

        slots[floor][slot] = null;
        return true;
    }
}

public class Task03 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of floors: ");
        int floors = sc.nextInt();
        int[] counts = new int[floors];

        for (int i = 0; i < floors; i++) {
            System.out.print("Enter slots on floor " + i + ": ");
            counts[i] = sc.nextInt();
        }

        ParkingFacility p = new ParkingFacility(counts);

        System.out.print("Enter number of vehicles to park: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            System.out.print("Enter vehicle number: ");
            String reg = sc.nextLine();
            int[] position = p.allocate(reg);

            if (position == null) {
                System.out.println("Parking full");
            } else {
                System.out.println("Allocated: [" + position[0] + ", " + position[1] + "]");
            }
        }

        System.out.print("Enter parking duration in minutes for fee: ");
        int minutes = sc.nextInt();
        int hours = (minutes + 59) / 60;
        System.out.println("Fee (Rs 30 per started hour): Rs " + (hours * 30.0));

        sc.close();
    }
}
