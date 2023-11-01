package trees.symmetric_tree_101.iterative;

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
    public boolean isSymmetric(TreeNode root) {
        ArrayDeque<TreeNode> stack1 = new ArrayDeque<>();
        ArrayDeque<TreeNode> stack2 = new ArrayDeque<>();

        if (root.left != null) {
            stack1.add(root.left);
        }
        if (root.right != null) {
            stack2.add(root.right);
        }
        while (!stack1.isEmpty() && !stack2.isEmpty()) {
            TreeNode node1 = stack1.getLast();
            TreeNode node2 = stack2.getLast();

            while (node1.left != null) {
                node1 = node1.left;
                stack1.add(node1);
            }
            while (node2.right != null) {
                node2 = node2.right;
                stack2.add(node2);
            }
            while (!stack1.isEmpty() && !stack2.isEmpty()) {
                node1 = stack1.pollLast();
                node2 = stack2.pollLast();
                if (node1.val != node2.val || node1.right == null && node2.left != null || node1.right != null && node2.left == null) {
                    return false;
                }
                if (node1.right != null && node2.left != null) {
                    stack1.addLast(node1.right);
                    stack2.addLast(node2.left);
                    break;
                }
            }
            if (stack1.size() != stack2.size()) {
                return false;
            }
        }
        return stack1.size() == stack2.size();
    }

    public static void main(String[] args) {
        /*
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(4);
        TreeNode node5 = new TreeNode(2, node1, node2);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(3);
        TreeNode node6 = new TreeNode(2, node3, node4);
        TreeNode node7 = new TreeNode(1, node5, node6);
        */
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3, node1, node2);

        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(3, null, node4);

        TreeNode node6 = new TreeNode(2, node3, node5);


        Solution s = new Solution();
        System.out.println(s.isSymmetric(node6));
    }
}