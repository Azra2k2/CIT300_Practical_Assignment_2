import java.util.List;

/**
 * AM. Saula Nora (Graph) - holds the outcome of one BFS/DFS traversal.
 */
public class TraversalResult {
    public final List<Integer> order;  // visiting order
    public final long steps;           // vertices processed + edges examined
    public final long nanos;           // execution time

    public TraversalResult(List<Integer> order, long steps, long nanos) {
        this.order = order;
        this.steps = steps;
        this.nanos = nanos;
    }
}
