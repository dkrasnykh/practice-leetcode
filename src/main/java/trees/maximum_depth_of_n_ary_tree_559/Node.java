package trees.maximum_depth_of_n_ary_tree_559;

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
    public int maxDepth(Node root) {
        if (root == null) {
            return 0;
        }
        if (root.children.size() == 0) {
            return 1;
        } else {
            int maxDept = Integer.MIN_VALUE;
            for (Node node : root.children) {
                maxDept = Math.max(maxDept, maxDepth(node));
            }
            return 1 + maxDept;
        }
    }

    public static void main(String[] args) {

    }
}
