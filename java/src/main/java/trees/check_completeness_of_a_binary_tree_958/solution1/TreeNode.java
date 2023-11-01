package trees.check_completeness_of_a_binary_tree_958.solution1;

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

//https://www.youtube.com/watch?v=olbiZ-EOSig
class Solution {
    public boolean isCompleteTree(TreeNode root) {
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        while (!q.isEmpty()) {
            TreeNode node = q.pollFirst();
            if (node.val != 0) {
                q.addLast(node.left == null ? new TreeNode(0) : node.left);
                q.addLast(node.right == null ? new TreeNode(0) : node.right);
            } else {
                while (!q.isEmpty()) {
                    if (q.pollFirst().val > 0) {
                        return false;
                    }
                }
            }
        }
        return true;
    }
}
