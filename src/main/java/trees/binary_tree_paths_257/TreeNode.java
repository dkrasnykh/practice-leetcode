package trees.binary_tree_paths_257;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
    private void dfs(TreeNode node, List<String> res, ArrayDeque<Integer> path) {
        if(node == null){
            return;
        }
        path.addLast(node.val);
        dfs(node.left, res, path);
        if (node.left == null && node.right == null) {
            String p = path.stream().map(s -> Integer.toString(s)).collect(Collectors.joining("->"));
            res.add(p);
        }
        dfs(node.right, res, path);
        path.pollLast();
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        ArrayDeque<Integer> path = new ArrayDeque<>();
        dfs(root, res, path);
        return res;
    }

    public static void main(String[] args) {
        TreeNode node5 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2, null, node5);
        TreeNode node1 = new TreeNode(1, node2, node3);

        Solution s = new Solution();
        System.out.println(s.binaryTreePaths(node1));
        /*
        TreeNode node3 = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2, node1, node3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node7 = new TreeNode(7);
        TreeNode node6 = new TreeNode(6, node5, node7);
        TreeNode node4 = new TreeNode(4, node2, node6);

        Solution s = new Solution();
        System.out.println(s.binaryTreePaths(node4));
        */
        /*
        TreeNode node = new TreeNode(1);
        Solution s = new Solution();
        System.out.println(s.binaryTreePaths(node));

         */
    }
}
