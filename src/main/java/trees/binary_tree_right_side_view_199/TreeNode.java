package trees.binary_tree_right_side_view_199;

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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList();
        if(root == null) return res;
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        while (!q.isEmpty()) {
            res.add(q.getLast().val);
            int lenght = q.size();
            for (int i = 0; i < lenght; ++i) {
                TreeNode node = q.pollFirst();
                if (node.left != null) {
                    q.add(node.left);
                }
                if (node.right != null) {
                    q.add(node.right);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
