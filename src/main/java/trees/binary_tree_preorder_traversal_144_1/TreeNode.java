package trees.binary_tree_preorder_traversal_144_1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=afTpieEZXck
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
        TreeNode current = root;
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        while (current != null || !stack.isEmpty()) {
            if (current != null) {
                res.add(current.val);
                if (current.right != null) {
                    stack.addLast(current.right);
                }
                current = current.left;
            } else {
                current = stack.pollLast();
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}