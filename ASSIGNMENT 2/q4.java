import java.util.*;

public class q4 {
    static void printMap(String title, Map<String, Integer> map) {
        System.out.println(title);
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + " -> " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Map<String, Integer> hashMap = new HashMap<>();
        Map<String, Integer> treeMap = new TreeMap<>();
        Map<String, Integer> linkedMap = new LinkedHashMap<>();

        System.out.print("Enter number of medicines: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter medicine code " + i + ": ");
            String code = sc.nextLine();
            System.out.print("Enter stock quantity: ");
            int quantity = sc.nextInt();
            sc.nextLine();

            hashMap.put(code, quantity);
            treeMap.put(code, quantity);
            linkedMap.put(code, quantity);
        }

        System.out.print("\nEnter medicine code to search: ");
        String searchCode = sc.nextLine();

        long start = System.nanoTime();
        Integer stock = hashMap.get(searchCode);
        long lookupTime = System.nanoTime() - start;
        System.out.println("HashMap stock: " + stock);
        System.out.println("One lookup time: " + lookupTime + " ns");

        System.out.println();
        printMap("HashMap (no order guaranteed):", hashMap);
        System.out.println();
        printMap("TreeMap (sorted by medicine code):", treeMap);
        System.out.println();
        printMap("LinkedHashMap (insertion order):", linkedMap);

        System.out.println("\nUse HashMap for fast average lookup, TreeMap for sorted reports,");
        System.out.println("and LinkedHashMap when insertion order must be preserved.");
        System.out.println("Hashtable is a legacy synchronized class; modern code usually");
        System.out.println("uses HashMap or an explicitly chosen concurrent collection.");
        sc.close();
    }
}
