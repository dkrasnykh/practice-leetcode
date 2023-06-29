package trees.minimum_distance_between_BST_nodes_783;

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
    private void dfs(TreeNode node, List<Integer> values) {
        if (node != null) {
            dfs(node.left, values);
            values.add(node.val);
            dfs(node.right, values);
        }
    }

    public int minDiffInBST(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        dfs(root, values);
        int diff = values.get(values.size()-1) - values.get(0);
        for(int i = 1; i < values.size(); ++i){
            diff = Math.min(diff, values.get(i) - values.get(i - 1));
        }
        return diff;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2, node1, node3);
        TreeNode node6 = new TreeNode(6);
        TreeNode node4 = new TreeNode(4, node2, node6);
        Solution s = new Solution();
        System.out.println(s.minDiffInBST(node4));
    }
}
