package trees.n_ary_tree_preorder_traversal_589.iterative;

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

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        ArrayDeque<Node> stack = new ArrayDeque<>();
        stack.addLast(root);
        while (!stack.isEmpty()) {
            Node curr = stack.pollLast();
            ans.add(curr.val);
            for (int i = curr.children.size() - 1; i >= 0; --i) {
                stack.addLast(curr.children.get(i));
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}