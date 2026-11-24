import java.util.*;

public class q5 {
    static class Team {
        final String name;
        final int points;
        final int goalDiff;

        Team(String name, int points, int goalDiff) {
            this.name = name;
            this.points = points;
            this.goalDiff = goalDiff;
        }

        @Override
        public String toString() {
            return name + "(" + points + "," + goalDiff + ")";
        }
    }

    static class Leaderboard<T> {
        private final List<T> items = new ArrayList<>();
        private final Comparator<? super T> order;

        Leaderboard(Comparator<? super T> order) {
            this.order = order;
        }

        void add(T item) {
            items.add(item);
        }

        List<T> ranking() {
            List<T> copy = new ArrayList<>(items);
            copy.sort(order);
            return copy;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Comparator<Team> byRank =
            Comparator.comparingInt((Team t) -> t.points).reversed()
                      .thenComparing(Comparator.comparingInt((Team t) -> t.goalDiff).reversed())
                      .thenComparing(t -> t.name);

        Leaderboard<Team> board = new Leaderboard<>(byRank);

        System.out.print("Enter number of teams: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {
            System.out.print("Enter team name: ");
            String name = sc.nextLine();
            System.out.print("Enter points: ");
            int points = sc.nextInt();
            System.out.print("Enter goal difference: ");
            int goalDiff = sc.nextInt();
            sc.nextLine();
            board.add(new Team(name, points, goalDiff));
        }

        System.out.println("\nRanking:");
        System.out.println(board.ranking());
        System.out.println("\nTie rule: points descending, goal difference descending,");
        System.out.println("then team name in alphabetical order.");
        sc.close();
    }
}
