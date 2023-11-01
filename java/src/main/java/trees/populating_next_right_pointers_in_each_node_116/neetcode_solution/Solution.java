package trees.populating_next_right_pointers_in_each_node_116.neetcode_solution;

//https://www.youtube.com/watch?v=U4hFQCa1Cq0
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
}

public class Solution {
    public Node connect(Node root) {
        Node cur = root, nxt = (root == null) ? null : root.left;
        while(cur != null && nxt != null){
            cur.left.next = cur.right;
            if(cur.next != null){
                cur.right.next = cur.next.left;
            }
            cur = cur.next;
            if(cur == null){
                cur = nxt;
                nxt = cur.left;
            }
        }
        return root;
    }
}
