package trees.subtree_of_another_tree_572;

import java.util.ArrayDeque;

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
    private boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }
        if (p == null || q == null || p.val != q.val) {
            return false;
        }
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        while (!q.isEmpty()) {
            TreeNode node = q.pollFirst();
            if(node.val == subRoot.val && isSameTree(node, subRoot)){
                return true;
            }
            if(node.left != null){
                q.addLast(node.left);
            }
            if(node.right != null){
                q.addLast(node.right);
            }
        }
        return false;
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root1 = new TreeNode(1);
        TreeNode root0 = new TreeNode(0);
        TreeNode root2 = new TreeNode(2, root0, null);
        TreeNode root4 = new TreeNode(4, root1, root2);
        TreeNode root5 = new TreeNode(5);
        TreeNode root3 = new TreeNode(3, root4, root5);


        TreeNode subRoot1 = new TreeNode(1);
        TreeNode subRoot2 = new TreeNode(2);
        TreeNode subRoot4 = new TreeNode(4, subRoot1, subRoot2);

        System.out.println(s.isSubtree(root3, subRoot4));
    }
}
