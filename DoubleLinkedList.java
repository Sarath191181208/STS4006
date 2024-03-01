import java.util.HashSet;

public class DoubleLinkedList {
    class Node {
        int val;
        Node next;
        Node prev;

        public Node(int val) {
            this.val = val;
        }

        public Node(int val, Node next, Node prev) {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }

    Node head = null;
    Node tail = null;
    int length = 0;

    public void insert(int val) {
        this.length++;
        if (head == null) {
            this.head = new Node(val);
            this.tail = this.head;
            return;
        }

        var temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = new Node(val, null, temp);
        this.tail = temp.next;
    }

    public void insertArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            insert(arr[i]);
        }
    }

    public String toString() {
        var sb = new StringBuilder();
        var s = new HashSet<Node>();
        var temp = head;
        while (temp.next != null) {
            if (s.contains(temp)) {
                sb.append(" (loop) ");
                break;
            }
            s.add(temp);
            sb.append(temp.val);
            sb.append(" <=> ");
            temp = temp.next;
        }
        sb.append(temp.val);

        return sb.toString();
    }

    public static void main(String[] args) {
        var list = new DoubleLinkedList();
        list.insertArray(new int[] { 1, 2, 3, 4, 5 });
        System.out.println(list);
    }
}
