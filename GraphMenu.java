/**
 * AM. Saula Nora (Graph) - console submenu for graph operations.
 */
public class GraphMenu {
    /** Shared so the Performance Comparison can traverse the same graph. */
    public static final GraphDS GRAPH = new GraphDS();

    public static void run() {
        while (true) {
            System.out.println("\n--------------- GRAPH OPERATIONS ---------------");
            System.out.println("1. Add Vertex");
            System.out.println("2. Add Edge (undirected)");
            System.out.println("3. Display Graph");
            System.out.println("4. BFS Traversal");
            System.out.println("5. DFS Traversal");
            System.out.println("6. Load Sample Graph");
            System.out.println("7. Return to Main Menu");
            int choice = InputHelper.readInt("Enter your choice: ", 1, 7);

            switch (choice) {
                case 1: {
                    int v = InputHelper.readInt("Vertex id (number): ");
                    System.out.println(GRAPH.addVertex(v)
                            ? "  Vertex " + v + " added."
                            : "  ! Vertex " + v + " already exists.");
                    break;
                }
                case 2: {
                    if (GRAPH.size() < 2) {
                        System.out.println("  ! Add at least two vertices first.");
                        break;
                    }
                    int a = InputHelper.readInt("From vertex: ");
                    int b = InputHelper.readInt("To vertex: ");
                    System.out.println("  " + GRAPH.addEdge(a, b));
                    break;
                }
                case 3:
                    GRAPH.display();
                    break;
                case 4:
                case 5: {
                    if (GRAPH.isEmpty()) {
                        System.out.println("  ! Graph is empty. Add vertices or load the sample graph.");
                        break;
                    }
                    int start = InputHelper.readInt("Start vertex: ");
                    if (!GRAPH.hasVertex(start)) {
                        System.out.println("  ! Vertex " + start + " does not exist.");
                        break;
                    }
                    boolean bfs = (choice == 4);
                    TraversalResult t = bfs ? GRAPH.bfs(start) : GRAPH.dfs(start);
                    String name = bfs ? "BFS" : "DFS";
                    System.out.println("  " + name + " order: " + t.order);
                    System.out.println("  Steps = " + t.steps + " | time = " + t.nanos + " ns");
                    ResultStore.add(ResultStore.row("Graph Traversal", name, t.steps, t.nanos, "Order " + t.order));
                    break;
                }
                case 6:
                    GRAPH.loadSample();
                    System.out.println("  Sample graph loaded (vertices 1-7).");
                    GRAPH.display();
                    break;
                case 7:
                    return;
            }
        }
    }
}
