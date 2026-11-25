import java.io.*;
import java.nio.file.*;
import java.util.Scanner;

public class BufferedLineCounter {
    static long count(Path path, boolean useBuffer) throws IOException {
        long lines = 0;
        boolean any = false;
        int last = -1;
        try (InputStream raw = Files.newInputStream(path);
             InputStream in = useBuffer ? new BufferedInputStream(raw) : raw) {
            int c;
            while ((c = in.read()) != -1) {
                any = true;
                last = c;
                if (c == '\n') lines++;
            }
        }
        if (any && last != '\n') lines++;
        return lines;
    }
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.print("Text file path: ");
        Path path = Paths.get(sc.nextLine());
        long start = System.nanoTime();
        long plain = count(path, false);
        long plainTime = System.nanoTime() - start;
        start = System.nanoTime();
        long buffered = count(path, true);
        long bufferedTime = System.nanoTime() - start;
        System.out.println("Unbuffered lines: " + plain + " | ms: " + plainTime / 1e6);
        System.out.println("Buffered lines: " + buffered + " | ms: " + bufferedTime / 1e6);
        System.out.println("Results match: " + (plain == buffered));
        sc.close();
    }
}
