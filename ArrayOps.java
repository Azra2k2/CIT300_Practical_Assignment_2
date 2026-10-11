import java.util.Arrays;

/**
 * J. Afrosha (Array) - fixed-capacity array with insert, delete, search, display.
 */
public class ArrayOps {
    private final int[] data;
    private int size;

    public ArrayOps(int capacity) {
        data = new int[capacity];
        size = 0;
    }

    public int size() { return size; }
    public int capacity() { return data.length; }
    public boolean isEmpty() { return size == 0; }
    public boolean isFull() { return size == data.length; }

    /** Insert at the end: O(1). */
    public boolean insert(int value) {
        if (isFull()) return false;
        data[size++] = value;
        return true;
    }

    /** Insert at a given index, shifting elements right: O(n). */
    public boolean insertAt(int index, int value) {
        if (isFull() || index < 0 || index > size) return false;
        for (int i = size; i > index; i--) {
            data[i] = data[i - 1];
        }
        data[index] = value;
        size++;
        return true;
    }

    /** Delete the first occurrence of a value, shifting elements left: O(n). */
    public boolean deleteValue(int value) {
        int idx = search(value);
        if (idx < 0) return false;
        for (int i = idx; i < size - 1; i++) {
            data[i] = data[i + 1];
        }
        size--;
        return true;
    }

    /** Linear search: O(n). Returns index or -1. */
    public int search(int value) {
        for (int i = 0; i < size; i++) {
            if (data[i] == value) return i;
        }
        return -1;
    }

    public int[] toArray() {
        return Arrays.copyOf(data, size);
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("  Array is empty.");
            return;
        }
        System.out.println("  " + Arrays.toString(toArray()) + "  (size " + size + "/" + data.length + ")");
    }
}
