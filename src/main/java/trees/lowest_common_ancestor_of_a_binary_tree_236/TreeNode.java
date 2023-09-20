package trees.lowest_common_ancestor_of_a_binary_tree_236;

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
    private boolean isExist(TreeNode node, int value){
        if(node == null){
            return false;
        }
        if(node.val == value){
            return true;
        }
        return isExist(node.left, value) || isExist(node.right, value);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null){
            return null;
        }
        if(root.val == p.val || root.val == q.val){
            return root;
        }
        boolean pLeft = isExist(root.left, p.val);
        boolean qRight = isExist(root.right, q.val);
        if (pLeft && qRight) {
            return root;
        }
        boolean qLeft = isExist(root.left, q.val);
        boolean pRight = isExist(root.right, p.val);
        if (qLeft && pRight){
            return root;
        }
        if(pLeft && qLeft){
            return lowestCommonAncestor(root.left, p, q);
        } else {
            return lowestCommonAncestor(root.right, p, q);
        }
    }
}