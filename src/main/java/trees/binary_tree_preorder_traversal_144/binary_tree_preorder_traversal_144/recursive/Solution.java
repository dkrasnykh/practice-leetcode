package trees.binary_tree_preorder_traversal_144.binary_tree_preorder_traversal_144.recursive;

import java.util.ArrayList;
import java.util.List;

class TreeNode {
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

public class Solution {
    private void preorder(List<Integer> vals, TreeNode root){
        if(root!=null){
            vals.add(root.val);
            preorder(vals, root.left);
            preorder(vals, root.right);
        }
    }

    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        //TreeNode current = root;
        preorder(res, root);
        return res;
    }
    public static void main(String[] args) {

    }
}
