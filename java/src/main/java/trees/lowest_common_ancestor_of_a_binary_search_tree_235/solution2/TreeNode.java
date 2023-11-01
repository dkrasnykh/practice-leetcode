package trees.lowest_common_ancestor_of_a_binary_search_tree_235.solution2;

//https://neetcode.io/practice
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {

    public TreeNode lowestCommonAncestor(
            TreeNode root,
            TreeNode p,
            TreeNode q
    ) {
        if (p.val > root.val && q.val > root.val) return lowestCommonAncestor(
                root.right,
                p,
                q
        );
        if (p.val < root.val && q.val < root.val) return lowestCommonAncestor(
                root.left,
                p,
                q
        );
        return root;
    }
}