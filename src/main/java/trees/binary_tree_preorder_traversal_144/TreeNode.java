package trees.binary_tree_preorder_traversal_144;

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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        TreeNode current = root;
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        res.add(current.val);
        stack.addLast(current);
        while (!stack.isEmpty() && current != null) {
            while (current.left != null) {
                current = current.left;
                res.add(current.val);
                stack.addLast(current);
            }
            while(!stack.isEmpty() && stack.getLast().right == null){
                stack.pollLast();
            }
            if(!stack.isEmpty()){
                current = stack.pollLast().right;
                stack.addLast(current);
                res.add(current.val);
            }
            /*
            current = stack.pollLast().right;
            stack.addLast(current);
            res.add(current.val);
            */
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        //System.out.println(s.preorderTraversal());
        /*
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2, node4, node5);
        TreeNode node3 = new TreeNode(3, node6, node7);
        TreeNode node1 = new TreeNode(1, node2, node3);
        System.out.println(s.preorderTraversal(node1));
        */
        TreeNode node3 = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2, node1, node3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node7 = new TreeNode(7);
        TreeNode node6 = new TreeNode(6, node5, node7);
        TreeNode node4 = new TreeNode(4, node2, node6);
        System.out.println(s.preorderTraversal(node4));
    }
}
