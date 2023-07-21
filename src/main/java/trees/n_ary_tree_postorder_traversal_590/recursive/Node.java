package trees.n_ary_tree_postorder_traversal_590.recursive;

import java.util.ArrayList;
import java.util.List;

class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};

class Solution {

    private void traversal(Node root, List<Integer> list) {
        if (root == null) {
            return;
        }
        for (Node node : root.children) {
            traversal(node, list);
        }
        list.add(root.val);
    }

    public List<Integer> postorder(Node root) {
        List<Integer> ans = new ArrayList<>();
        traversal(root, ans);
        return ans;
    }

    public static void main(String[] args) {

    }
}
