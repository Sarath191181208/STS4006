import java.util.Arrays;
import java.util.Scanner;


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