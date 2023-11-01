package linked_list.copy_list_with_random_pointer_138;

import java.util.HashMap;
import java.util.Map;

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
        if(head == null) return null;
        Map<Node, Integer> nodes1 = new HashMap<>();
        Map<Integer, Node> nodes2 = new HashMap<>();
        int i = 1;
        nodes1.put(head, 0);
        Node curr = head.next;
        Node newHead = new Node(head.val);
        Node newPrev = newHead;
        nodes2.put(0, newHead);
        while(curr != null){
            nodes1.put(curr, i);

            Node newNode = new Node(curr.val);
            newPrev.next = newNode;
            nodes2.put(i, newNode);
            newPrev = newNode;

            i += 1;
            curr = curr.next;
        }
        curr = head;
        Node curr2 = newHead;

        while(curr!=null){
            if(curr.random != null){
                int ind = nodes1.get(curr.random);
                curr2.random = nodes2.get(ind);
            }
            curr = curr.next;
            curr2 = curr2.next;
        }

        return newHead;
    }

    private void print(Node head) {
        while (head != null) {
            System.out.print("[" + head.val + ", "+((head.random==null)?"null":head.random.val)+"] ");
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;

        Solution s = new Solution();
        s.print(s.copyRandomList(node1));
    }
}