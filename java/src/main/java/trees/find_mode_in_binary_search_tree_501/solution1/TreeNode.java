package trees.find_mode_in_binary_search_tree_501.solution1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    private int max_cnt;
    private void dfs(TreeNode node, Map<Integer, Integer> map) {
        if (node == null) {
            return;
        }
        dfs(node.left, map);
        map.compute(node.val, (k, v) -> v == null ? 1 : v + 1);
        max_cnt = Math.max(max_cnt, map.get(node.val));
        dfs(node.right, map);
    }

    public int[] findMode(TreeNode root) {
        max_cnt = 0;
        Map<Integer, Integer> map = new HashMap<>();
        dfs(root, map);
        List<Integer> res = new ArrayList<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue().equals(max_cnt)) {
                res.add(entry.getKey());
            }
        }
        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); ++i) {
            ans[i] = res.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
