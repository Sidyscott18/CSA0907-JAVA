import java.util.Scanner;

class ParkingSlot {
    private int slotNumber;
    private boolean occupied;

    public void setSlotNumber(int slotNumber) {
        if (slotNumber > 0) {
            this.slotNumber = slotNumber;
        } else {
            System.out.println("Invalid slot number");
        }
    }

    public int getSlotNumber() {
        return slotNumber;
    }

    public void setOccupied(boolean occupied) {
        this.occupied = occupied;
    }

    public boolean isOccupied() {
        return occupied;
    }
}

public class Task10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ParkingSlot slot = new ParkingSlot();

        System.out.print("Enter slot number: ");
        int number = sc.nextInt();

        slot.setSlotNumber(number);
        System.out.print("Is the slot occupied? (true/false): ");
        boolean status = sc.nextBoolean();

        slot.setOccupied(status);

        if (slot.getSlotNumber() > 0) {
            System.out.println("Slot number: " + slot.getSlotNumber());
            System.out.println("Occupied: " + slot.isOccupied());
        }
        sc.close();
    }
}
