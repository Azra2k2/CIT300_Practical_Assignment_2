/**
 * Naseeha (Integration) - Performance / complexity demonstration.
 * Compares Linear vs Binary search and BFS vs DFS (steps + execution time).
 */
public class PerformanceComparison {

    public static void run() {
        System.out.println("\n--- Search test uses a sorted array of even numbers (worst case: last element) ---");
        int n = InputHelper.readInt("Array size (10 - 1000000): ", 10, 1000000);
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = i * 2;
        }
        int key = data[n - 1];

        SearchResult lin = SearchOps.linearSearch(data, key);
        SearchResult bin = SearchOps.binarySearch(data, key);

        GraphDS graph = GraphMenu.GRAPH;
        if (graph.isEmpty()) {
            System.out.println("  Graph is empty - loading the sample graph for the traversal test.");
            graph.loadSample();
        }
        int start = graph.firstVertex();
        TraversalResult bfs = graph.bfs(start);
        TraversalResult dfs = graph.dfs(start);

        System.out.println("\n=============================================");
        System.out.println(" PERFORMANCE COMPARISON");
        System.out.println("=============================================");
        System.out.println(ResultStore.header());
        System.out.println("-----------------------------------------------------------------------------");
        show(ResultStore.row("Search", "Linear Search", lin.steps, lin.nanos, "n = " + n));
        show(ResultStore.row("Search", "Binary Search", bin.steps, bin.nanos, "n = " + n));
        show(ResultStore.row("Graph Traversal", "BFS", bfs.steps, bfs.nanos, "start " + start));
        show(ResultStore.row("Graph Traversal", "DFS", dfs.steps, dfs.nanos, "start " + start));
        System.out.println("=============================================");
        System.out.println("Why the results differ:");
        System.out.println(" - Linear search checks elements one by one: O(n) -> about " + lin.steps + " steps.");
        System.out.println(" - Binary search halves the range each time: O(log n) -> about " + bin.steps + " steps.");
        System.out.println(" - BFS and DFS both visit every vertex and examine every edge: O(V + E).");
        System.out.println("   Their step counts are similar; only the visiting order differs.");
        System.out.println(" - Time (ns) can vary between runs (JVM warm-up); step counts are the reliable measure.");
    }

    private static void show(String row) {
        System.out.println(row);
        ResultStore.add(row);
    }
}
