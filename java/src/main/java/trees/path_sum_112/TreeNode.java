package trees.path_sum_112;

import java.util.HashSet;
import java.util.Set;

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
    private void helper(TreeNode root, int curSum, Set<Integer> total) {
        if (root.left == null && root.right == null) {
            curSum += root.val;
            total.add(curSum);
        } else {
            curSum += root.val;
            if (root.left != null) {
                helper(root.left, curSum, total);
            }
            if (root.right != null) {
                helper(root.right, curSum, total);
            }
        }
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        Set<Integer> total = new HashSet<>();
        helper(root, 0, total);
        return total.contains(targetSum);
    }

    public static void main(String[] args) {

    }
}
