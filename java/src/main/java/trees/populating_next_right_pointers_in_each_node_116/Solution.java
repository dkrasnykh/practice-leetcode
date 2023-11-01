package trees.populating_next_right_pointers_in_each_node_116;

import java.util.ArrayDeque;
import java.util.Objects;

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

class Pair<T, V> {
    private T first;
    private V second;

    public Pair(T first, V second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pair<?, ?> pair = (Pair<?, ?>) o;
        return Objects.equals(first, pair.first) && Objects.equals(second, pair.second);
    }

    @Override
    public int hashCode() {
        return Objects.hash(first, second);
    }

    public T getFirst() {
        return first;
    }

    public V getSecond() {
        return second;
    }
}

public class Solution {
    public Node connect(Node root) {
        if (root==null) return null;
        ArrayDeque<Pair<Node, Integer>> q = new ArrayDeque<>();
        q.add(new Pair<>(root, 0));
        while (!q.isEmpty()) {
            Pair<Node, Integer> node = q.pollFirst();
            int d = node.getSecond();
            if(node.getFirst().left != null){
                q.add(new Pair<>(node.getFirst().left, node.getSecond() + 1));
                q.add(new Pair<>(node.getFirst().right, node.getSecond() + 1));
            }
            while(!q.isEmpty() && q.getFirst().getSecond().equals(d)){
                Pair<Node, Integer> next = q.pollFirst();
                node.getFirst().next = next.getFirst();
                node = next;
                if(node.getFirst().left != null){
                    q.add(new Pair<>(node.getFirst().left, node.getSecond() + 1));
                    q.add(new Pair<>(node.getFirst().right, node.getSecond() + 1));
                }
            }
        }
        return root;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        Node node4 = new Node(4);
        Node node5 = new Node(5);
        Node node6 = new Node(6);
        Node node7 = new Node(7);
        Node node2 = new Node(2, node4, node5, null);
        Node node3 = new Node(3, node6, node7, null);
        Node node1 = new Node(1, node2, node3, null);
        Node root = s.connect(node1);
        int test = 5;
    }
}
