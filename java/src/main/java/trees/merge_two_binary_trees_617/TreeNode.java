package trees.merge_two_binary_trees_617;

import java.util.Objects;

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
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        int value = (Objects.isNull(root1) ? 0 : root1.val) + (Objects.isNull(root2) ? 0 : root2.val);
        TreeNode root = new TreeNode(value);
        root.left = mergeTrees(Objects.isNull(root1) ? null : root1.left, Objects.isNull(root2) ? null : root2.left);
        root.right = mergeTrees(Objects.isNull(root1) ? null : root1.right, Objects.isNull(root2) ? null : root2.right);
        return root;
    }

    public static void main(String[] args) {

    }
}