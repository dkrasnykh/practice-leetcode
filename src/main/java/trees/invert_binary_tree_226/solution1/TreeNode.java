package trees.binary_tree_preorder_traversal_144_1.solution1;

//https://www.youtube.com/watch?v=OnSn2XEQ4MY
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

class Solution{
    public TreeNode invertTree(TreeNode root) {
        if (root==null){
            return null;
        }
        TreeNode tmp = root.left;
        root.left = root.right;
        root.right = tmp;
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
    public static void main(String[] args) {

    }
}