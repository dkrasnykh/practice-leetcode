package trees.find_bottom_left_tree_value_513.solution2;

import java.util.ArrayDeque;
import java.util.Collections;

//https://www.youtube.com/watch?v=u_by_cTsNJA
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
    public int findBottomLeftValue(TreeNode root) {
        ArrayDeque<TreeNode> q = new ArrayDeque<>(Collections.singletonList(root));
        TreeNode node = null;
        while (!q.isEmpty()) {
            node = q.pollFirst();
            if (node.right != null) q.addLast(node.right);
            if (node.left != null) q.addLast(node.left);
        }
        return node.val;
    }

    public static void main(String[] args) {

    }
}
