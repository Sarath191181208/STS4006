
public class SeggregateEvenOdd {

    public static void seggregateEvenOdd(List list){
        var head = list.head;
        var even = new List();
        var odd = new List();
        var temp = head;
        while (temp != null){
            if (temp.val % 2 == 0){
                even.insert(temp.val);
            } else {
                odd.insert(temp.val);
            }
            temp = temp.next;
        }
        // temp = even.head;
        // while (temp.next != null){
        //     temp = temp.next;
        // }
        temp = odd.head;
        while (temp.next != null){
            temp = temp.next;
        }
        // temp.next = odd.head;
        // list.head = even.head;
        temp.next = even.head;
        list.head = odd.head;
    }

    public static void main(String[] args) {
        var ll = new List();
        var arr = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        ll.insertArray(arr);
        System.out.println(ll.toString());
        seggregateEvenOdd(ll);
        System.out.println(ll.toString());
    }
}
