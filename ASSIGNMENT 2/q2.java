import java.util.*;

public class q2 {
    static long timeAddEnd(List<Integer> list, int n) {
        long start = System.nanoTime();
        for (int i = 0; i < n; i++) list.add(i);
        return System.nanoTime() - start;
    }

    static long timeFrontInsert(List<Integer> list, int n) {
        long start = System.nanoTime();
        for (int i = 0; i < n; i++) list.add(0, i);
        return System.nanoTime() - start;
    }

    static long timeMiddleInsert(List<Integer> list, int n) {
        long start = System.nanoTime();
        for (int i = 0; i < n; i++) list.add(list.size() / 2, i);
        return System.nanoTime() - start;
    }

    static long timeFrontRemove(List<Integer> list) {
        long start = System.nanoTime();
        while (!list.isEmpty()) list.remove(0);
        return System.nanoTime() - start;
    }

    static long timeMiddleRemove(List<Integer> list) {
        long start = System.nanoTime();
        while (!list.isEmpty()) list.remove(list.size() / 2);
        return System.nanoTime() - start;
    }

    static long timeGetMiddle(List<Integer> list, int repetitions) {
        long sum = 0;
        long start = System.nanoTime();
        for (int i = 0; i < repetitions; i++) sum += list.get(list.size() / 2);
        long elapsed = System.nanoTime() - start;
        if (sum == Long.MIN_VALUE) System.out.println(sum);
        return elapsed;
    }

    static long timeIteration(List<Integer> list) {
        long sum = 0;
        long start = System.nanoTime();
        for (int value : list) sum += value;
        long elapsed = System.nanoTime() - start;
        if (sum == Long.MIN_VALUE) System.out.println(sum);
        return elapsed;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter playlist size (try 1000, 5000 or 10000): ");
        int n = sc.nextInt();
        System.out.print("Enter number of repeated k-th element accesses: ");
        int repetitions = sc.nextInt();

        if (n < 1 || repetitions < 1) {
            System.out.println("Enter positive values only.");
            sc.close();
            return;
        }

        List<Integer> a = new ArrayList<>();
        List<Integer> l = new LinkedList<>();
        List<Integer> d = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(i); l.add(i); d.add(i);
        }

        System.out.println("\nOperation timings (nanoseconds):");
        System.out.println("ArrayList get(k): " + timeGetMiddle(a, repetitions));
        System.out.println("LinkedList get(k): " + timeGetMiddle(l, repetitions));
        System.out.println("ArrayList iteration: " + timeIteration(a));
        System.out.println("LinkedList iteration: " + timeIteration(l));
        System.out.println("ArrayList add at end: " + timeAddEnd(new ArrayList<>(), n));
        System.out.println("LinkedList add at end: " + timeAddEnd(new LinkedList<>(), n));

        System.out.println("ArrayList insert at front: " + timeFrontInsert(new ArrayList<>(a), n));
        System.out.println("LinkedList insert at front: " + timeFrontInsert(new LinkedList<>(a), n));
        System.out.println("ArrayList insert in middle: " + timeMiddleInsert(new ArrayList<>(a), n));
        System.out.println("LinkedList insert in middle: " + timeMiddleInsert(new LinkedList<>(a), n));
        System.out.println("ArrayList remove at front: " + timeFrontRemove(new ArrayList<>(a)));
        System.out.println("LinkedList remove at front: " + timeFrontRemove(new LinkedList<>(a)));
        System.out.println("ArrayList remove in middle: " + timeMiddleRemove(new ArrayList<>(a)));
        System.out.println("LinkedList remove in middle: " + timeMiddleRemove(new LinkedList<>(a)));

        ArrayDeque<Integer> upNext = new ArrayDeque<>();
        for (int i = 0; i < n; i++) upNext.addLast(i);
        long start = System.nanoTime();
        for (int i = 0; i < n / 2; i++) {
            upNext.addFirst(-i);
            upNext.addLast(i);
            upNext.removeFirst();
        }
        System.out.println("ArrayDeque add/remove at both ends: " + (System.nanoTime() - start) + " ns");

        System.out.println("\nConclusion: ArrayList suits frequent indexed access and iteration.");
        System.out.println("LinkedList may suit frequent end operations but uses extra node memory.");
        System.out.println("ArrayDeque is usually a better choice for an Up Next double-ended queue.");
        sc.close();
    }
}
