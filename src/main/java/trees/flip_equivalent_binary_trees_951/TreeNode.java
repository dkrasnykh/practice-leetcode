package trees.flip_equivalent_binary_trees_951;

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
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        /*
        valid base case:
        https://www.youtube.com/watch?v=izRDc1il9Pk
        if (root1 == null || root2 == null) {
            return root1==null && root2==null;
        }
        if (root1.val != root2.val) {
            return false;
        }
        */
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null || root1.val != root2.val) {
            return false;
        }
        return flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right) ||
                flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);

    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        //TreeNode node4 = new TreeNode(9);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node5.left = node7;
        node5.right = node8;
        node3.left = node6;

        TreeNode node21 = new TreeNode(1);
        TreeNode node22 = new TreeNode(2);
        TreeNode node23 = new TreeNode(3);
        TreeNode node24 = new TreeNode(4);
        TreeNode node25 = new TreeNode(5);
        TreeNode node26 = new TreeNode(6);
        TreeNode node27 = new TreeNode(7);
        TreeNode node28 = new TreeNode(8);

        node21.left = node23;
        node21.right = node22;
        node23.right = node26;
        node22.left = node24;
        node22.right = node25;
        node25.left = node28;
        node25.right = node27;

        Solution s = new Solution();

        System.out.println(s.flipEquiv(node1, node21));
    }
}
