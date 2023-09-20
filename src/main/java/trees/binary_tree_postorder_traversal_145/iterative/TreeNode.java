package trees.binary_tree_postorder_traversal_145.iterative;

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
    public List<Integer> postorderTraversal(TreeNode root) {
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        ArrayDeque<Boolean> visit = new ArrayDeque<>();
        List<Integer> res = new ArrayList<>();
        if (root != null) {
            stack.addLast(root);
            visit.addLast(false);
        }
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pollLast();
            Boolean v = visit.pollLast();
            if (cur != null) {
                if (v) {
                    res.add(cur.val);
                } else {
                    stack.addLast(cur);
                    visit.addLast(true);
                    if (cur.right != null) {
                        stack.addLast(cur.right);
                        visit.addLast(false);
                    }
                    if (cur.left != null) {
                        stack.addLast(cur.left);
                        visit.addLast(false);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node3 = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2, node1, node3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node7 = new TreeNode(7);
        TreeNode node6 = new TreeNode(6, node5, node7);
        TreeNode node4 = new TreeNode(4, node2, node6);
        Solution s = new Solution();
        System.out.println(s.postorderTraversal(node4));
    }
}