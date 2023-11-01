package trees.kth_smallest_element_in_a_BST_230.iterative;

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
    public int kthSmallest(TreeNode root, int k) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        int value = 0;
        stack.addLast(root);
        TreeNode curr = root;
        while (k > 0 && !stack.isEmpty()) {
            while (curr != null && curr.left != null) {
                curr = curr.left;
                stack.addLast(curr);
            }
            curr = stack.pollLast();
            value = curr.val;
            k -= 1;
            curr = curr.right;
            if (curr != null) {
                stack.addLast(curr);
            }
        }
        return value;
    }

    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1, null, node2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3, node1, node4);
        Solution s = new Solution();
        System.out.println(s.kthSmallest(node3, 1));
    }
}