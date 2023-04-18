package trees.maximum_depth_of_binary_tree_104;

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
    class Pair<F, S> {
        F first;
        S second;

        public Pair(F first, S second) {
            this.first = first;
            this.second = second;
        }
    }

    public int maxDepth(TreeNode root) {
        int maxdept = 0;
        if (root == null) {
            return maxdept;
        }
        ArrayDeque<Pair<TreeNode, Integer>> q = new ArrayDeque<>();
        q.addLast(new Pair<>(root, 1));
        while (!q.isEmpty()) {
            Pair<TreeNode, Integer> p = q.pollFirst();
            maxdept = Math.max(maxdept, p.second);
            if (p.first.left != null) {
                q.addLast(new Pair<>(p.first.left, p.second + 1));
            }
            if (p.first.right != null) {
                q.addLast(new Pair<>(p.first.right, p.second + 1));
            }
        }
        return maxdept;
    }

    public int maxDepthDFS(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return 1 + Math.max(maxDepthDFS(root.left), maxDepthDFS(root.right));
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        /*
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);

        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node3 = new TreeNode(3, node6, node7);

        TreeNode node1 = new TreeNode(1, node2, node3);
        System.out.println(s.maxDepth(node1));
        */
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1, node2, null);
        System.out.println(s.maxDepth(node1));
    }
}