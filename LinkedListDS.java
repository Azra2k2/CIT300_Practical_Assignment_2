/**
 * Naseeha (Linked List) - singly linked list with insert, delete, search, display.
 */
public class LinkedListDS {

    private static class Node {
        int value;
        Node next;
        Node(int value) { this.value = value; }
    }

    private Node head;
    private int size;

    public boolean isEmpty() { return head == null; }

    /** O(1). */
    public void insertAtBeginning(int value) {
        Node node = new Node(value);
        node.next = head;
        head = node;
        size++;
    }

    /** O(n) - walks to the last node. */
    public void insertAtEnd(int value) {
        Node node = new Node(value);
        if (head == null) {
            head = node;
        } else {
            Node cur = head;
            while (cur.next != null) cur = cur.next;
            cur.next = node;
        }
        size++;
    }

    /** Deletes the first node holding the value: O(n). */
    public boolean delete(int value) {
        if (head == null) return false;
        if (head.value == value) {
            head = head.next;
            size--;
            return true;
        }
        Node cur = head;
        while (cur.next != null && cur.next.value != value) cur = cur.next;
        if (cur.next == null) return false;
        cur.next = cur.next.next;
        size--;
        return true;
    }

    /** Returns 1-based position or -1 if not found: O(n). */
    public int search(int value) {
        Node cur = head;
        int pos = 1;
        while (cur != null) {
            if (cur.value == value) return pos;
            cur = cur.next;
            pos++;
        }
        return -1;
    }

    public void display() {
        if (head == null) {
            System.out.println("  Linked list is empty.");
            return;
        }
        StringBuilder sb = new StringBuilder("  ");
        for (Node cur = head; cur != null; cur = cur.next) {
            sb.append(cur.value).append(" -> ");
        }
        System.out.println(sb.append("null").append("  (size ").append(size).append(")"));
    }
}
