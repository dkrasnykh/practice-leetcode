package trees.balanced_binary_tree_110;

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
    private int dfs(TreeNode root, List<Boolean> balanced) {
        if (root == null) {
            return 0;
        }
        int leftHight = dfs(root.left, balanced);
        int rightHight = dfs(root.right, balanced);
        if (Math.abs(leftHight - rightHight) > 1) {
            balanced.set(0, false);
        }
        return 1 + Math.max(leftHight, rightHight);
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        List<Boolean> balanced = new ArrayList<>();
        balanced.add(true);
        dfs(root, balanced);
        return balanced.get(0);
    }

    public static void main(String[] args) {

    }
}