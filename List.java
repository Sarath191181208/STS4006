import java.util.HashSet;

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