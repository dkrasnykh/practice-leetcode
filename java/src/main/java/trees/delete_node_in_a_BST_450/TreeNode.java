package trees.delete_node_in_a_BST_450;

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
    private void dfs(TreeNode prev, TreeNode curr, int key) {
        if (curr != null) {
            if (curr.val == key) {
                if (curr.left == null && curr.right == null) {
                    if (prev.left == curr) {
                        prev.left = null;
                    } else {
                        prev.right = null;
                    }
                } else {
                    TreeNode left = curr.left;
                    TreeNode right = curr.right;
                    if (right == null) {
                        if (prev.left == curr) {
                            prev.left = left;
                        } else {
                            prev.right = left;
                        }
                    } else {
                        TreeNode rightLeft = right.left;
                        if (rightLeft == null) {
                            if (prev.left == curr) {
                                prev.left = right;
                                prev.left.left = left;
                            } else {
                                prev.right = right;
                                prev.right.left = left;
                            }
                        } else {
                            TreeNode prev1 = right;
                            TreeNode curr1 = rightLeft;
                            while (curr1.left != null) {
                                prev1 = curr1;
                                curr1 = curr1.left;
                            }
                            prev1.left = curr1.right;
                            if (prev.left == curr) {
                                prev.left = curr1;
                            } else {
                                prev.right = curr1;
                            }
                            curr1.left = left;
                            curr1.right = right;
                        }
                    }
                }
                return;
            }
            dfs(curr, curr.left, key);
            dfs(curr, curr.right, key);
        }
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode dummy = new TreeNode(0, root, null);
        TreeNode prev = dummy;
        TreeNode curr = root;
        dfs(prev, curr, key);
        return dummy.left;
    }

    public static void main(String[] args) {
    }
}
