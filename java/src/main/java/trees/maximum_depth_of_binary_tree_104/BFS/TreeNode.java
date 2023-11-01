package trees.maximum_depth_of_binary_tree_104.BFS;

import java.util.ArrayDeque;

//https://www.youtube.com/watch?v=hTM3phVI6YQ
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
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int level = 0;
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        while (!q.isEmpty()) {
            int len = q.size();
            for (int i = 0; i < len; ++i) {
                TreeNode node = q.pollFirst();
                if (node.left != null) {
                    q.addLast(node.left);
                }
                if (node.right != null) {
                    q.addLast(node.right);
                }
            }
            level += 1;
        }
        return level;
    }

    public static void main(String[] args) {

    }
}