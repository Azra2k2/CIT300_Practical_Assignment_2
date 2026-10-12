/**
 * S. Azra Banu (Stack) - array-based stack (LIFO) with overflow/underflow handling.
 */
public class StackDS {
    private final int[] data;
    private int top = -1;

    public StackDS(int capacity) {
        data = new int[capacity];
    }

    public boolean isEmpty() { return top == -1; }
    public boolean isFull() { return top == data.length - 1; }

    public void push(int value) {
        if (isFull()) throw new IllegalStateException("Stack Overflow: stack is full.");
        data[++top] = value;
    }

    public int pop() {
        if (isEmpty()) throw new IllegalStateException("Stack Underflow: cannot pop from an empty stack.");
        return data[top--];
    }

    public int peek() {
        if (isEmpty()) throw new IllegalStateException("Stack is empty: nothing to peek.");
        return data[top];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("  Stack is empty.");
            return;
        }
        System.out.println("  Stack (top -> bottom):");
        for (int i = top; i >= 0; i--) {
            System.out.println("    | " + data[i] + " |" + (i == top ? "  <- top" : ""));
        }
    }
}
