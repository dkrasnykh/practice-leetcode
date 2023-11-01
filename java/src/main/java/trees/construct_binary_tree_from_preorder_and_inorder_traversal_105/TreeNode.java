package trees.construct_binary_tree_from_preorder_and_inorder_traversal_105;

import java.util.HashMap;
import java.util.Map;

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
    private TreeNode build(int i, int l, int r, int[] preorder, Map<Integer, Integer> inorder) {
        if (r < l) {
            return null;
        }
        TreeNode node = new TreeNode(preorder[i]);
        int ind = inorder.get(preorder[i]);
        node.left = build(i + 1, l, ind - 1, preorder, inorder);
        node.right = build(i + (ind - l) + 1, ind + 1, r, preorder, inorder);
        return node;
    }

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; ++i) {
            inorderMap.put(inorder[i], i);
        }
        return build(0, 0, preorder.length - 1, preorder, inorderMap);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode node = s.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        TreeNode node1 = s.buildTree(new int[]{1, 2, 3}, new int[]{2, 3, 1});
    }
}
