/**
 * J. Afrosha (Searching) - Linear Search and Binary Search with step counting.
 */
public class SearchOps {

    /** Linear search: checks each element in turn. Time O(n). */
    public static SearchResult linearSearch(int[] a, int key) {
        long start = System.nanoTime();
        long steps = 0;
        int found = -1;
        for (int i = 0; i < a.length; i++) {
            steps++;
            if (a[i] == key) {
                found = i;
                break;
            }
        }
        return new SearchResult(found, steps, System.nanoTime() - start);
    }

    /** Binary search: array MUST be sorted. Time O(log n). */
    public static SearchResult binarySearch(int[] a, int key) {
        long start = System.nanoTime();
        long steps = 0;
        int low = 0, high = a.length - 1, found = -1;
        while (low <= high) {
            steps++;
            int mid = low + (high - low) / 2;
            if (a[mid] == key) {
                found = mid;
                break;
            } else if (a[mid] < key) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return new SearchResult(found, steps, System.nanoTime() - start);
    }
}
