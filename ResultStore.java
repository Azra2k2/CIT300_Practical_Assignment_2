import java.util.ArrayList;
import java.util.List;

/**
 * AM. Saula Nora - stores every recorded result so that
 * main menu option 8 ("Display All Results") can show them.
 */
public class ResultStore {
    private static final List<String> RESULTS = new ArrayList<>();

    public static void add(String row) {
        RESULTS.add(row);
    }

    public static String header() {
        return String.format("%-16s %-14s %8s %12s  %s",
                "Operation", "Algorithm", "Steps", "Time (ns)", "Details");
    }

    public static String row(String op, String algo, long steps, long nanos, String details) {
        return String.format("%-16s %-14s %8d %12d  %s", op, algo, steps, nanos, details);
    }

    public static void displayAll() {
        System.out.println("\n=============================================");
        System.out.println(" ALL RECORDED RESULTS");
        System.out.println("=============================================");
        if (RESULTS.isEmpty()) {
            System.out.println("No results recorded yet. Run searches, traversals or the performance comparison.");
            return;
        }
        System.out.println(header());
        System.out.println("-----------------------------------------------------------------------------");
        for (String row : RESULTS) {
            System.out.println(row);
        }
    }
}
