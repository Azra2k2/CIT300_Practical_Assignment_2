/**
 * CIT300 - Data Structure & Graph Performance Analyzer
 * Naseeha (Integration) - main menu that connects every component.
 *
 * Run:  javac *.java   then   java Main
 */
public class Main {

    public static void main(String[] args) {
        boolean running = true;
        while (running) {
            System.out.println("\n=============================================");
            System.out.println(" DATA STRUCTURE & GRAPH ANALYZER");
            System.out.println("=============================================");
            System.out.println("1. Array Operations");
            System.out.println("2. Stack Operations");
            System.out.println("3. Queue Operations");
            System.out.println("4. Linked List Operations");
            System.out.println("5. Searching Operations");
            System.out.println("6. Graph Operations");
            System.out.println("7. Performance Comparison");
            System.out.println("8. Display All Results");
            System.out.println("9. Exit");
            int choice = InputHelper.readInt("Enter your choice: ", 1, 9);

            switch (choice) {
                case 1: ArrayMenu.run(); break;
                case 2: StackMenu.run(); break;
                case 3: QueueMenu.run(); break;
                case 4: LinkedListMenu.run(); break;
                case 5: SearchMenu.run(); break;
                case 6: GraphMenu.run(); break;
                case 7: PerformanceComparison.run(); break;
                case 8: ResultStore.displayAll(); break;
                case 9:
                    System.out.println("Goodbye!");
                    running = false;
                    break;
            }
        }
    }
}
