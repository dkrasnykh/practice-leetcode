package trees.path_sum_112.solution2;

//https://neetcode.io/practice
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
    private boolean isLeafNode(TreeNode node) {
        return ((node.left == null) && (node.right == null));
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {
        // Edge case: No nodes
        if(root == null) {
            return false;
        }

        targetSum -= root.val;
        if(isLeafNode(root)) {
            return (targetSum == 0);
        }
        return hasPathSum(root.left, targetSum) || hasPathSum(root.right, targetSum);
    }

    public static void main(String[] args) {

    }
}
