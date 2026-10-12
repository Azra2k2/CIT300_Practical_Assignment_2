/**
 * S. Azra Banu (Stack) - console submenu for stack operations.
 */
public class StackMenu {
    private static final StackDS STACK = new StackDS(10);

    public static void run() {
        while (true) {
            System.out.println("\n--------------- STACK OPERATIONS (LIFO) ---------------");
            System.out.println("1. Push   - O(1)");
            System.out.println("2. Pop    - O(1)");
            System.out.println("3. Peek   - O(1)");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");
            int choice = InputHelper.readInt("Enter your choice: ", 1, 5);

            try {
                switch (choice) {
                    case 1: {
                        int v = InputHelper.readInt("Value to push: ");
                        STACK.push(v);
                        System.out.println("  Pushed " + v);
                        break;
                    }
                    case 2:
                        System.out.println("  Popped " + STACK.pop());
                        break;
                    case 3:
                        System.out.println("  Top element: " + STACK.peek());
                        break;
                    case 4:
                        STACK.display();
                        break;
                    case 5:
                        return;
                }
            } catch (IllegalStateException e) {
                System.out.println("  ! " + e.getMessage());
            }
        }
    }
}
