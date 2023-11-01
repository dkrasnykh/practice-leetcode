package trees.insert_into_a_binary_search_tree_701;

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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode node = new TreeNode(val);
        TreeNode cur = root;
        while (cur != null) {
            if (cur.val < val && cur.right == null) {
                cur.right = node;
                return root;
            } else if (cur.val < val) {
                cur = cur.right;
            } else if (cur.val > val && cur.left == null) {
                cur.left = node;
                return root;
            } else if (cur.val > val) {
                cur = cur.left;
            }
        }
        return node;
    }

    public static void main(String[] args) {

    }
}