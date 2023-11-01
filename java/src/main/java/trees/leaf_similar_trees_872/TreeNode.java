package trees.leaf_similar_trees_872;

import java.util.ArrayList;
import java.util.List;

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
    private void dfs(TreeNode root, List<Integer> leaf) {
        if (root.left == null && root.right == null) {
            leaf.add(root.val);
            return;
        }
        if (root.left != null) {
            dfs(root.left, leaf);
        }
        if (root.right != null) {
            dfs(root.right, leaf);
        }
    }
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaf1 = new ArrayList<>();
        dfs(root1, leaf1);
        List<Integer> leaf2 = new ArrayList<>();
        dfs(root2, leaf2);
        return leaf1.equals(leaf2);
    }

    public static void main(String[] args) {

    }
}
