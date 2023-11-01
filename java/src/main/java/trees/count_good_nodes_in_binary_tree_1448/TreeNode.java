package trees.count_good_nodes_in_binary_tree_1448;

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
    private int dfs(TreeNode node, int maxValue) {
        if(node == null){
            return 0;
        }
        int res = (node.val >= maxValue)?1:0;
        maxValue = Math.max(maxValue, node.val);
        res += dfs(node.left, maxValue);
        res += dfs(node.right, maxValue);
        return res;
    }

    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        /*
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(1);
        TreeNode node6 = new TreeNode(5);
        TreeNode node2 = new TreeNode(1, node4, null);
        TreeNode node3 = new TreeNode(4, node5, node6);
        TreeNode node1 = new TreeNode(3, node2, node3);

        System.out.println(s.goodNodes(node1));

        TreeNode node13 = new TreeNode(4);
        TreeNode node14 = new TreeNode(2);
        TreeNode node12 = new TreeNode(3, node13, node14);
        TreeNode node11 = new TreeNode(3, node12, null);

        System.out.println(s.goodNodes(node11));
        */
        //TreeNode node11 = new TreeNode(1);

        //System.out.println(s.goodNodes(node11));

        TreeNode node25 = new TreeNode(4);
        TreeNode node24 = new TreeNode(8, node25, null);
        TreeNode node23 = new TreeNode(10);
        TreeNode node22 = new TreeNode(4, node23, node24);
        TreeNode node21 = new TreeNode(2, null, node22);

        System.out.println(s.goodNodes(node21));

    }
}