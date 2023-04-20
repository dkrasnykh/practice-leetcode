package trees.diameter_of_binary_tree_543;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

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

    public int dfs(TreeNode root, List<Integer> d) {
        if (root == null) {
            return 0;
        }
        int leftd = dfs(root.left, d);
        int rightd = dfs(root.right, d);
        d.set(0, Math.max(d.get(0), leftd + rightd));
        return 1 + Math.max(leftd, rightd);
    }

    public int diameterOfBinaryTree(TreeNode root) {
        List<Integer> d = new ArrayList<>();
        d.add(0);
        dfs(root, d);
        return d.get(0);
    }

    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node3 = new TreeNode(3, node6, node7);
        TreeNode node1 = new TreeNode(1, node2, node3);
        Solution s = new Solution();
        s.diameterOfBinaryTree(node1);

    }
}