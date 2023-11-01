package trees.check_completeness_of_a_binary_tree_958;

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
    public boolean isCompleteTree(TreeNode root) {
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            boolean containsNull = false;
            boolean fullness = (size == (1 << level));
            for (int i = 0; i < size; ++i) {
                TreeNode curr = q.pollFirst();
                if (curr.left == null && curr.right != null || ((curr.left != null || curr.right != null) && (containsNull || !fullness))) {
                    return false;
                }
                if (curr.left == null || curr.right == null) {
                    containsNull = true;
                }
                if (curr.left != null) {
                    q.addLast(curr.left);
                }
                if (curr.right != null) {
                    q.addLast(curr.right);
                }
            }
            level += 1;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
