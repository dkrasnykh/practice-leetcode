package trees.average_of_levels_in_binary_tree_637;

import java.util.ArrayDeque;
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
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> ans = new ArrayList<>();
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        while (!q.isEmpty()) {
            int n = q.size();
            double value = 0;
            for (int i = 0; i < n; ++i) {
                TreeNode tmp = q.pollFirst();
                if (tmp.left != null) {
                    q.addLast(tmp.left);
                }
                if (tmp.right != null) {
                    q.addLast(tmp.right);
                }
                value += tmp.val;
            }
            ans.add(value / n);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode node15 = new TreeNode(15);
        TreeNode node7 = new TreeNode(7);
        TreeNode node20 = new TreeNode(20, node15, node7);
        TreeNode node9 = new TreeNode(9);
        TreeNode node3 = new TreeNode(3, node9, node20);
        Solution s = new Solution();
        System.out.println(s.averageOfLevels(node3));
    }
}
