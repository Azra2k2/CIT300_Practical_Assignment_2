import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.TreeMap;

/**
 * AM. Saula Nora (Graph) - undirected graph using an adjacency list,
 * with BFS and DFS traversal (time complexity O(V + E)).
 */
public class GraphDS {
    private final Map<Integer, List<Integer>> adjacency = new TreeMap<>();

    public boolean isEmpty() { return adjacency.isEmpty(); }
    public int size() { return adjacency.size(); }
    public boolean hasVertex(int v) { return adjacency.containsKey(v); }
    public int firstVertex() { return adjacency.keySet().iterator().next(); }

    public boolean addVertex(int v) {
        if (adjacency.containsKey(v)) return false;
        adjacency.put(v, new ArrayList<>());
        return true;
    }

    /** Adds an undirected edge and returns a message describing the outcome. */
    public String addEdge(int a, int b) {
        if (!hasVertex(a) || !hasVertex(b)) return "! Both vertices must exist first.";
        if (a == b) return "! Self-loops are not allowed.";
        if (adjacency.get(a).contains(b)) return "! Edge " + a + " - " + b + " already exists.";
        adjacency.get(a).add(b);
        adjacency.get(b).add(a);
        Collections.sort(adjacency.get(a));
        Collections.sort(adjacency.get(b));
        return "Edge " + a + " - " + b + " added.";
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("  Graph is empty.");
            return;
        }
        System.out.println("  Adjacency list:");
        for (Map.Entry<Integer, List<Integer>> e : adjacency.entrySet()) {
            System.out.println("    " + e.getKey() + " -> " + e.getValue());
        }
    }

    /** Breadth-first traversal using a queue. Time O(V + E). */
    public TraversalResult bfs(int start) {
        long t0 = System.nanoTime();
        long steps = 0;
        List<Integer> order = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();

        visited.add(start);
        queue.add(start);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            steps++;                       // vertex processed
            order.add(v);
            for (int n : adjacency.get(v)) {
                steps++;                   // edge examined
                if (visited.add(n)) queue.add(n);
            }
        }
        return new TraversalResult(order, steps, System.nanoTime() - t0);
    }

    /** Depth-first traversal using a stack. Time O(V + E). */
    public TraversalResult dfs(int start) {
        long t0 = System.nanoTime();
        long steps = 0;
        List<Integer> order = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        Deque<Integer> stack = new ArrayDeque<>();

        stack.push(start);
        while (!stack.isEmpty()) {
            int v = stack.pop();
            steps++;                       // vertex taken from stack
            if (!visited.add(v)) continue;
            order.add(v);
            List<Integer> neighbours = adjacency.get(v);
            for (int i = neighbours.size() - 1; i >= 0; i--) {
                steps++;                   // edge examined
                int n = neighbours.get(i);
                if (!visited.contains(n)) stack.push(n);
            }
        }
        return new TraversalResult(order, steps, System.nanoTime() - t0);
    }

    /** Sample graph with vertices 1-7 for quick demonstrations. */
    public void loadSample() {
        adjacency.clear();
        for (int v = 1; v <= 7; v++) addVertex(v);
        int[][] edges = {{1, 2}, {1, 3}, {2, 4}, {2, 5}, {3, 6}, {3, 7}, {5, 6}};
        for (int[] e : edges) addEdge(e[0], e[1]);
    }
