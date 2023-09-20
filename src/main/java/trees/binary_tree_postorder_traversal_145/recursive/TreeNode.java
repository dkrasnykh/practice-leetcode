package trees.binary_tree_postorder_traversal_145.recursive;

import java.util.ArrayList;
import java.util.List;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {
    }
    TreeNode(int val) {
        this.val = val;
    }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    private void postorder(List<Integer> vals, TreeNode node) {
        if (node != null) {
            postorder(vals, node.left);
            postorder(vals, node.right);
            vals.add(node.val);
        }
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postorder(res, root);
        return res;
    }

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2, node1, node3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node7 = new TreeNode(7);
        TreeNode node6 = new TreeNode(6, node5, node7);
        TreeNode node4 = new TreeNode(4, node2, node6);
        Solution s = new Solution();
        List<Integer> res = s.postorderTraversal(node4);
        System.out.println(res);
    }
}