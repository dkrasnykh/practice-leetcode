package trees.minimum_depth_of_binary_tree_111;

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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int depthLeft = minDepth(root.left);
        int depthRight = minDepth(root.right);
        if (depthLeft == 0 && depthRight == 0 || depthLeft > 0 && depthRight > 0) {
            return 1 + Math.min(depthLeft, depthRight);
        } else {
            return 1 + Math.max(depthLeft, depthRight);
        }
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
        System.out.println(s.minDepth(node4));

        /*
        TreeNode node6 = new TreeNode(6);
        TreeNode node5 = new TreeNode(5, null, node6);
        TreeNode node4 = new TreeNode(4, null, node5);
        TreeNode node3 = new TreeNode(3, null, node4);
        TreeNode node2 = new TreeNode(2, null, node3);

        Solution s = new Solution();
        System.out.println(s.minDepth(node2));
        */
    }
}