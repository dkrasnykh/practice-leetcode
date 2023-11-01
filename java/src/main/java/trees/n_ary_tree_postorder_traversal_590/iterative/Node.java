package trees.n_ary_tree_postorder_traversal_590.iterative;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

class Pair {
    Node node;
    boolean visited;

    public Pair(Node node, boolean visited) {
        this.node = node;
        this.visited = visited;
    }
}

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        ArrayDeque<Pair> stack = new ArrayDeque<>();
        stack.addLast(new Pair(root, false));
        while (!stack.isEmpty()) {
            Pair p = stack.pollLast();
            if (p.visited) {
                ans.add(p.node.val);
            } else {
                stack.addLast(new Pair(p.node, true));
                for (int i = p.node.children.size() - 1; i >= 0; --i) {
                    stack.addLast(new Pair(p.node.children.get(i), false));
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}