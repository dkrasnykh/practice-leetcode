package trees.convert_bst_to_greater_tree_538;
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
class Solution {
    public TreeNode dfs(TreeNode root, int[] total){
        if(root == null){
            return root;
        }
        dfs(root.right, total);
        int tmp = root.val;
        root.val += total[0];
        total[0] += tmp;
        dfs(root.left, total);
        return root;
    }
    public TreeNode convertBST(TreeNode root) {
        return dfs(root, new int[]{0});
    }

    public static void main(String[] args) {
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7, null, node8);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6, node5, node7);

        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2, null, node3);
        TreeNode node0 = new TreeNode(0);
        TreeNode node1 = new TreeNode(1, node0, node2);

        TreeNode node4 = new TreeNode(4, node1, node6);

        Solution s = new Solution();
        TreeNode root = s.convertBST(node4);
    }
}
