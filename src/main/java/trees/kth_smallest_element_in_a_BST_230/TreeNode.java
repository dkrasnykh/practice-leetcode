package trees.kth_smallest_element_in_a_BST_230;

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
    private void traversal(TreeNode root, List<Integer> values) {
        if (root != null) {
            traversal(root.left, values);
            values.add(root.val);
            traversal(root.right, values);
        }
    }
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> values = new ArrayList<>();
        traversal(root, values);
        return values.get(k - 1);
    }

    public static void main(String[] args) {
        TreeNode node2 = new TreeNode(2);
        TreeNode node1 = new TreeNode(1, null, node2);
        TreeNode node4 = new TreeNode(4);
        TreeNode node3 = new TreeNode(3, node1, node4);
        Solution s = new Solution();
        System.out.println(s.kthSmallest(node3, 4));

    }
}
