package trees.find_bottom_left_tree_value_513;

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
    private int height(TreeNode node) {
        if (node == null) {
            return 0;
        }
        if (node.left == null && node.right == null) {
            return 1;
        }
        return 1 + Math.max(height(node.left), height(node.right));
    }

    private void dfs(TreeNode root, int h, int height, List<Integer> path) {
        if (root == null || root.left == null && root.right == null) {
            if (h == height && root != null) {
                path.add(root.val);
            }
            return;
        }
        dfs(root.left, h + 1, height, path);
        dfs(root.right, h + 1, height, path);
    }

    public int findBottomLeftValue(TreeNode root) {
        int h = height(root);
        List<Integer> ans = new ArrayList<>();
        dfs(root, 1, h, ans);
        return ans.get(0);
    }

    public static void main(String[] args) {
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node3 = new TreeNode(3, node6, node7);
        TreeNode node1 = new TreeNode(1, node2, node3);
        Solution s = new Solution();
        System.out.println(s.findBottomLeftValue(node1));
    }
}
