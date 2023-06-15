package trees.sum_root_to_leaf_numbers_129;

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
    private void dfs(TreeNode node, ArrayDeque<Integer> path, List<String> ans) {
        if (node == null) {
            return;
        }
        if (node.left == null && node.right == null) {
            StringBuilder builder = new StringBuilder();
            for (Integer p : path) {
                builder.append(p);
            }
            builder.append(node.val);
            ans.add(builder.toString());
        }
        path.add(node.val);
        dfs(node.left, path, ans);
        dfs(node.right, path, ans);
        path.pollLast();
    }

    public int sumNumbers(TreeNode root) {
        ArrayDeque<Integer> path = new ArrayDeque<>();
        List<String> ans = new ArrayList<>();
        dfs(root, path, ans);
        int res = 0;
        for(String s : ans){
            res += Integer.parseInt(s);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1, null, node2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3, node1, node4);
        Solution s = new Solution();
        System.out.println(s.sumNumbers(node3));
    }
}