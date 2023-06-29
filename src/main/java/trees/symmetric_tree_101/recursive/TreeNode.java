package trees.symmetric_tree_101.recursive;

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
    private boolean dfs(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        } else if (left == null || right==null){
            return false;
        }
        return left.val==right.val &&
                dfs(left.left, right.right) &&
                dfs(left.right, right.left);
    }
    public boolean isSymmetric(TreeNode root) {
        return dfs(root.left, root.right);
    }

    public static void main(String[] args) {
        /*
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(4);
        TreeNode node5 = new TreeNode(2, node1, node2);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(3);
        TreeNode node6 = new TreeNode(2, node3, node4);
        TreeNode node7 = new TreeNode(1, node5, node6);
        Solution s = new Solution();
        System.out.println(s.isSymmetric(node7));
        */
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2, node1, node3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node4 = new TreeNode(4, node2, node6);
        Solution s = new Solution();
        System.out.println(s.isSymmetric(node4));

    }
}
