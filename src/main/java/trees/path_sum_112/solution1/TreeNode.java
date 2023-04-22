package trees.path_sum_112.solution1;

import java.util.Objects;

//https://www.youtube.com/watch?v=LSKQyOz_P8I
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
    private boolean dfs(TreeNode root, int curSum, int targetSum) {
        if (root == null) {
            return false;
        }
        curSum += root.val;
        if (root.left == null && root.right == null) {
            return curSum == targetSum;
        }
        return dfs(Objects.isNull(root.left) ? null : root.left, curSum, targetSum) ||
                dfs(Objects.isNull(root.right) ? null : root.right, curSum, targetSum);
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return dfs(root, 0, targetSum);
    }

    public static void main(String[] args) {

    }
}
