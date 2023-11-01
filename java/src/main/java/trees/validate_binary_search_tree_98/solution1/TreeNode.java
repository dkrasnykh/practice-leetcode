package trees.validate_binary_search_tree_98.solution1;

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
    private boolean dfs(TreeNode root, long minvalue, long maxvalue) {
        if (root == null) {
            return true;
        }
        if(!(root.val > minvalue && root.val < maxvalue)){
            return false;
        }
        return dfs(root.left, minvalue, Math.min(maxvalue, root.val)) && dfs(root.right, Math.max(root.val, minvalue), maxvalue);
    }

    public boolean isValidBST(TreeNode root) {
        long min = Integer.MIN_VALUE;
        long max = Integer.MAX_VALUE;
        return dfs(root, min-10, max+10);
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node1 = new TreeNode(2, node2, node3);
        System.out.println(s.isValidBST(node1));

        TreeNode node14 = new TreeNode(3);
        TreeNode node15 = new TreeNode(6);
        TreeNode node13 = new TreeNode(4, node14, node15);
        TreeNode node12 = new TreeNode(1);
        TreeNode node11 = new TreeNode(5, node12, node13);
        System.out.println(s.isValidBST(node11));

        TreeNode node24 = new TreeNode(3);
        TreeNode node25 = new TreeNode(7);
        TreeNode node23 = new TreeNode(6, node24, node25);
        TreeNode node22 = new TreeNode(4);
        TreeNode node21 = new TreeNode(5, node22, node23);
        System.out.println(s.isValidBST(node21));
    }
}