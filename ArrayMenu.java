/**
 * J. Afrosha (Array) - console submenu for array operations.
 */
public class ArrayMenu {
    /** Shared so the Searching menu can search these values. */
    public static final ArrayOps ARRAY = new ArrayOps(20);

    public static void run() {
        while (true) {
            System.out.println("\n--------------- ARRAY OPERATIONS ---------------");
            System.out.println("1. Insert (at end)        - O(1)");
            System.out.println("2. Insert at index        - O(n)");
            System.out.println("3. Delete by value        - O(n)");
            System.out.println("4. Search (linear)        - O(n)");
            System.out.println("5. Display");
            System.out.println("6. Return to Main Menu");
            int choice = InputHelper.readInt("Enter your choice: ", 1, 6);

            switch (choice) {
                case 1: {
                    int v = InputHelper.readInt("Value to insert: ");
                    System.out.println(ARRAY.insert(v)
                            ? "  Inserted " + v
                            : "  ! Array is full (capacity " + ARRAY.capacity() + ").");
                    break;
                }
                case 2: {
                    int idx = InputHelper.readInt("Index (0 to " + ARRAY.size() + "): ", 0, ARRAY.size());
                    int v = InputHelper.readInt("Value to insert: ");
                    System.out.println(ARRAY.insertAt(idx, v)
                            ? "  Inserted " + v + " at index " + idx
                            : "  ! Array is full (capacity " + ARRAY.capacity() + ").");
                    break;
                }
                case 3: {
                    if (ARRAY.isEmpty()) {
                        System.out.println("  ! Array is empty. Nothing to delete.");
                        break;
                    }
                    int v = InputHelper.readInt("Value to delete: ");
                    System.out.println(ARRAY.deleteValue(v)
                            ? "  Deleted " + v
                            : "  ! Value " + v + " not found.");
                    break;
                }
                case 4: {
                    if (ARRAY.isEmpty()) {
                        System.out.println("  ! Array is empty.");
                        break;
                    }
                    int v = InputHelper.readInt("Value to search: ");
                    int idx = ARRAY.search(v);
                    System.out.println(idx >= 0
                            ? "  Found " + v + " at index " + idx
                            : "  ! Value " + v + " not found.");
                    break;
                }
                case 5:
                    ARRAY.display();
                    break;
                case 6:
                    return;
            }
        }
    }
}
