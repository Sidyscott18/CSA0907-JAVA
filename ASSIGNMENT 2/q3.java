import java.util.*;

public class q3 {
    static class Student {
        String regNo;
        String name;

        Student(String regNo, String name) {
            this.regNo = regNo;
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Student)) return false;
            Student other = (Student) o;
            return regNo.equals(other.regNo);
        }

        // Correct implementation: equal registration numbers get equal hash codes.
        @Override
        public int hashCode() {
            return Objects.hash(regNo);
        }

        @Override
        public String toString() {
            return regNo + " " + name;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<Student> present = new HashSet<>();

        System.out.print("Enter number of attendance scans: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter register number for scan " + i + ": ");
            String reg = sc.nextLine();
            System.out.print("Enter student name: ");
            String name = sc.nextLine();
            present.add(new Student(reg, name));
        }

        System.out.println("\nUnique students: " + present.size());
        System.out.println("Students in set (order is not guaranteed):");
        for (Student s : present) System.out.println(s);

        System.out.println("\nContract: if equals() returns true, hashCode() must return");
        System.out.println("the same value. Use immutable key fields after insertion.");
        sc.close();
    }
}
