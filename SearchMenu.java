import java.util.Arrays;

/**
 * J. Afrosha (Searching) - console submenu comparing Linear and Binary search
 * on the values stored in the Array component.
 */
public class SearchMenu {

    public static void run() {
        while (true) {
            System.out.println("\n--------------- SEARCHING OPERATIONS ---------------");
            System.out.println("(Searches the values stored in the Array component)");
            System.out.println("1. Linear Search   - O(n)");
            System.out.println("2. Binary Search   - O(log n)  [works on a sorted copy]");
            System.out.println("3. Compare both");
            System.out.println("4. Return to Main Menu");
            int choice = InputHelper.readInt("Enter your choice: ", 1, 4);
            if (choice == 4) {
                return;
            }

            int[] data = ArrayMenu.ARRAY.toArray();
            if (data.length == 0) {
                System.out.println("  ! Array is empty. Insert values in Array Operations first.");
                continue;
            }
            int key = InputHelper.readInt("Value to search: ");

            int[] sorted = data.clone();
            Arrays.sort(sorted);

            if (choice == 1 || choice == 3) {
                System.out.println("  Array: " + Arrays.toString(data));
                runAndRecord("Linear Search", data, key);
            }
            if (choice == 2 || choice == 3) {
                System.out.println("  Sorted copy: " + Arrays.toString(sorted));
                runAndRecord("Binary Search", sorted, key);
            }
        }
    }

    private static void runAndRecord(String algorithm, int[] data, int key) {
        SearchResult r = algorithm.startsWith("Linear")
                ? SearchOps.linearSearch(data, key)
                : SearchOps.binarySearch(data, key);
        String outcome = r.index >= 0 ? "Found at index " + r.index : "Not found";
        System.out.println("  " + algorithm + ": " + outcome
                + " | steps = " + r.steps + " | time = " + r.nanos + " ns");
        ResultStore.add(ResultStore.row("Search", algorithm, r.steps, r.nanos, outcome + " (key " + key + ")"));
    }
}
