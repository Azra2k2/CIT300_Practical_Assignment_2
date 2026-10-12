/**
 * Naseeha (Linked List) - console submenu for linked list operations.
 */
public class LinkedListMenu {
    private static final LinkedListDS LIST = new LinkedListDS();

    public static void run() {
        while (true) {
            System.out.println("\n--------------- LINKED LIST OPERATIONS ---------------");
            System.out.println("1. Insert at beginning   - O(1)");
            System.out.println("2. Insert at end         - O(n)");
            System.out.println("3. Delete by value       - O(n)");
            System.out.println("4. Search                - O(n)");
            System.out.println("5. Display");
            System.out.println("6. Return to Main Menu");
            int choice = InputHelper.readInt("Enter your choice: ", 1, 6);

            switch (choice) {
                case 1: {
                    int v = InputHelper.readInt("Value to insert: ");
                    LIST.insertAtBeginning(v);
                    System.out.println("  Inserted " + v + " at the beginning.");
                    break;
                }
                case 2: {
                    int v = InputHelper.readInt("Value to insert: ");
                    LIST.insertAtEnd(v);
                    System.out.println("  Inserted " + v + " at the end.");
                    break;
                }
                case 3: {
                    if (LIST.isEmpty()) {
                        System.out.println("  ! List is empty. Nothing to delete.");
                        break;
                    }
                    int v = InputHelper.readInt("Value to delete: ");
                    System.out.println(LIST.delete(v)
                            ? "  Deleted " + v
                            : "  ! Value " + v + " not found.");
                    break;
                }
                case 4: {
                    if (LIST.isEmpty()) {
                        System.out.println("  ! List is empty.");
                        break;
                    }
                    int v = InputHelper.readInt("Value to search: ");
                    int pos = LIST.search(v);
                    System.out.println(pos > 0
                            ? "  Found " + v + " at position " + pos
                            : "  ! Value " + v + " not found.");
                    break;
                }
                case 5:
                    LIST.display();
                    break;
                case 6:
                    return;
            }
        }
    }
}
