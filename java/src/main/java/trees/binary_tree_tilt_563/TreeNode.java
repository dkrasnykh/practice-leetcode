package trees.binary_tree_tilt_563;

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
    int total;
    private int dfs(TreeNode node){
        if(node == null){
            return 0;
        }
        int leftTotal = dfs(node.left);
        int rightTotal = dfs(node.right);
        total += Math.abs(leftTotal - rightTotal);
        return node.val + leftTotal + rightTotal;
    }
    public int findTilt(TreeNode root) {
        dfs(root);
        return total;
    }

    public static void main(String[] args) {
        /*
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node1 = new TreeNode(1, node2, node3);
        Solution s = new Solution();
        System.out.println(s.findTilt(node1));
         */
    }
}