import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

class Node {
    int val;
    Node next;

    public Node(int val){
        this.val = val;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}

class DetectLoop{
    public boolean isLooping(List list){
        var head = list.head;
        
        var slow = head.next;
        var fast = head.next.next;
        while (slow != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}

class List{
    Node head = null;
    int length = 0;

    public void insert(int val){
        this.length++;
        if (head == null){
            this.head = new Node(val);
            return;
        }

        var temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = new Node(val);
    }

    public void insertArray(int[] arr){
        for (int i = 0; i < arr.length; i++){
            insert(arr[i]);
        }
    }

    public String toString(){
        var sb = new StringBuilder();
        var s = new HashSet<Node>();
        var temp = head;
        while (temp.next != null){
            if(s.contains(temp)){
                sb.append(" (loop) ");
                break;
            }
            s.add(temp);
            sb.append(temp.val);
            sb.append(" -> ");
            temp = temp.next;
        }
        sb.append(temp.val);

        return sb.toString();
    }
}

public class LoopDetection{
    public static void main(String[] args){
        var sc = new Scanner(System.in);
        System.out.print("Enter the elements seperated by space: ");
        var n = sc.nextLine().split(" ");
        int[] arr = Arrays.stream(n).mapToInt(Integer::parseInt).toArray();

        var ll = new List();
        var loopDetector = new DetectLoop();
        ll.insertArray(arr);

        ll.head.next.next.next.next = ll.head; // creating a loop

        System.out.println(ll.toString());
        System.out.println(loopDetector.isLooping(ll));
        sc.close();
    }
}