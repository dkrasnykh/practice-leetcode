package trees.binary_tree_maximum_path_sum_124;

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
    private int dfs(TreeNode node, int[] res){
        if(node == null){
            return 0;
        }
        int leftSum = dfs(node.left, res);
        int rightSum = dfs(node.right, res);
        leftSum = Math.max(0, leftSum);
        rightSum = Math.max(0, rightSum);
        res[0] = Math.max(res[0], node.val + leftSum + rightSum);
        return Math.max(leftSum, rightSum) + node.val;
    }

    public int maxPathSum(TreeNode root) {
        int[] res = new int[]{Integer.MIN_VALUE};
        dfs(root, res);
        return res[0];
    }
}
