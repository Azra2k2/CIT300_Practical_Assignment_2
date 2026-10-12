/**
 * S. Azra Banu (Queue) - circular-array queue (FIFO) with overflow/underflow handling.
 */
public class QueueDS {
    private final int[] data;
    private int front = 0;
    private int count = 0;

    public QueueDS(int capacity) {
        data = new int[capacity];
    }

    public boolean isEmpty() { return count == 0; }
    public boolean isFull() { return count == data.length; }

    public void enqueue(int value) {
        if (isFull()) throw new IllegalStateException("Queue Overflow: queue is full.");
        int rear = (front + count) % data.length;
        data[rear] = value;
        count++;
    }

    public int dequeue() {
        if (isEmpty()) throw new IllegalStateException("Queue Underflow: cannot dequeue from an empty queue.");
        int value = data[front];
        front = (front + 1) % data.length;
        count--;
        return value;
    }

    public int peek() {
        if (isEmpty()) throw new IllegalStateException("Queue is empty: nothing at the front.");
        return data[front];
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("  Queue is empty.");
            return;
        }
        StringBuilder sb = new StringBuilder("  Front -> ");
        for (int i = 0; i < count; i++) {
            sb.append(data[(front + i) % data.length]);
            if (i < count - 1) sb.append(", ");
        }
        System.out.println(sb.append(" <- Rear"));
    }
}
