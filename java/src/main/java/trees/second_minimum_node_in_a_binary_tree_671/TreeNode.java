package trees.second_minimum_node_in_a_binary_tree_671;

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

    private long secondMin = Long.MAX_VALUE;

    private void dfs(TreeNode root, int firstMin) {
        if (root == null) {
            return;
        }
        if (root.val != firstMin) {
            secondMin = Math.min(secondMin, root.val);
            return;
        }
        dfs(root.left, firstMin);
        dfs(root.right, firstMin);
    }

    public int findSecondMinimumValue(TreeNode root) {
        dfs(root, root.val);
        return secondMin == Long.MAX_VALUE ? -1 : (int)secondMin;
    }

    public static void main(String[] args) {

    }
}
