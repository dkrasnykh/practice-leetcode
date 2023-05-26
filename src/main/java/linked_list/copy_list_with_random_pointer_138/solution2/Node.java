package linked_list.copy_list_with_random_pointer_138.solution2;

import java.util.HashMap;
import java.util.Map;

//https://www.youtube.com/watch?v=5Y2EiZST97Y
public class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        Map<Node, Node> oldToCopy = new HashMap<>();
        Node cur = head;
        while(cur != null){
            Node copy = new Node(cur.val);
            oldToCopy.put(cur, copy);
            cur = cur.next;
        }
        cur = head;
        while(cur != null){
            Node copy = oldToCopy.get(cur);
            copy.next = oldToCopy.get(cur.next);
            copy.random = oldToCopy.get(cur.random);
            cur = cur.next;
        }
        return oldToCopy.get(head);
    }
}
