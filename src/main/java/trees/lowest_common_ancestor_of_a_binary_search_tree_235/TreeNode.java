package trees.lowest_common_ancestor_of_a_binary_search_tree_235;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    private void dfs(TreeNode root, List<Integer> path, List<Integer> height, Map<Integer, Integer> first, int h) {
        if (root == null) {
            return;
        }
        dfs(root.left, path, height, first, h + 1);
        path.add(root.val);
        height.add(h);
        if (!first.containsKey(root.val)) {
            first.put(root.val, path.size() - 1);
        }
        dfs(root.right, path, height, first, h + 1);
        path.add(root.val);
        height.add(h);
        if (!first.containsKey(root.val)) {
            first.put(root.val, path.size() - 1);
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<Integer> tmp = new ArrayList<>();
        List<Integer> height = new ArrayList<>();
        Map<Integer, Integer> first = new HashMap<>();
        dfs(root, tmp, height, first, 1);
        int start = first.get(p.val) < first.get(q.val) ? first.get(p.val) : first.get(q.val);
        int end = first.get(p.val) < first.get(q.val) ? first.get(q.val) : first.get(p.val);
        int imin = start;
        for(int i = start; i <=end; ++i){
            if(height.get(imin)>height.get(i)){
                imin = i;
            }
        }
        return new TreeNode(tmp.get(imin));
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        node4.left = node3;
        node4.right = node5;
        TreeNode node0 = new TreeNode(0);
        TreeNode node2 = new TreeNode(2);
        node2.left = node0;
        node2.right = node4;
        TreeNode node7 = new TreeNode(7);
        TreeNode node9 = new TreeNode(9);
        TreeNode node8 = new TreeNode(8);
        node8.left = node7;
        node8.right = node9;
        TreeNode node6 = new TreeNode(6);
        node6.left = node2;
        node6.right = node8;
        //s.lowestCommonAncestor(node6, new TreeNode(2), new TreeNode(8));
        System.out.println(s.lowestCommonAncestor(node6, new TreeNode(2), new TreeNode(4)).val);
    }
}
