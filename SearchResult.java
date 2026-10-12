/**
 * J. Afrosha (Searching) - holds the outcome of one search.
 */
public class SearchResult {
    public final int index;    // -1 if not found
    public final long steps;   // number of comparisons
    public final long nanos;   // execution time

    public SearchResult(int index, long steps, long nanos) {
        this.index = index;
        this.steps = steps;
        this.nanos = nanos;
    }
}
