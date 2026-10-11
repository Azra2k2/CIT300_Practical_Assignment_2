/**
 * Azra Banu (Queue) - console submenu for queue operations.
 */
public class QueueMenu {
    private static final QueueDS QUEUE = new QueueDS(10);

    public static void run() {
        while (true) {
            System.out.println("\n--------------- QUEUE OPERATIONS (FIFO) ---------------");
            System.out.println("1. Enqueue       - O(1)");
            System.out.println("2. Dequeue       - O(1)");
            System.out.println("3. Peek / Front  - O(1)");
            System.out.println("4. Display");
            System.out.println("5. Return to Main Menu");
            int choice = InputHelper.readInt("Enter your choice: ", 1, 5);

            try {
                switch (choice) {
                    case 1: {
                        int v = InputHelper.readInt("Value to enqueue: ");
                        QUEUE.enqueue(v);
                        System.out.println("  Enqueued " + v);
                        break;
                    }
                    case 2:
                        System.out.println("  Dequeued " + QUEUE.dequeue());
                        break;
                    case 3:
                        System.out.println("  Front element: " + QUEUE.peek());
                        break;
                    case 4:
                        QUEUE.display();
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
