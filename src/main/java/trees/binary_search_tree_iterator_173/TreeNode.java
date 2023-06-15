package trees.binary_search_tree_iterator_173;

import java.util.ArrayDeque;

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

class BSTIterator {
    private ArrayDeque<TreeNode> st1;
    private ArrayDeque<TreeNode> st2;

    public BSTIterator(TreeNode root) {
        this.st1 = new ArrayDeque<>();
        this.st2 = new ArrayDeque<>();

        TreeNode tmp = root;
        while (tmp != null) {
            st1.addLast(tmp);
            while (tmp.right != null) {
                TreeNode tmp1 = tmp.right;
                while (!st1.isEmpty() && st1.getLast().val < tmp1.val) {
                    st2.addLast(st1.pollLast());
                }
                st1.addLast(tmp1);
                tmp = tmp1;
            }
            if (tmp.left != null) {
                tmp = tmp.left;
            } else {
                tmp = null;
                while (!st2.isEmpty()) {
                    TreeNode tmp1 = st2.pollLast();
                    st1.addLast(tmp1);
                    if (tmp1.left != null) {
                        tmp = tmp1.left;
                        break;
                    }
                }
            }
        }
    }

    public int next() {
        return st1.pollLast().val;
    }

    public boolean hasNext() {
        return !st1.isEmpty();
    }

    public static void main(String[] args) {

        TreeNode node6 = new TreeNode(6);
        TreeNode node8 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7, node6, node8);

        TreeNode node2 = new TreeNode(2);
        TreeNode node5 = new TreeNode(5, node2, node7);

        TreeNode node11 = new TreeNode(11);
        TreeNode node20 = new TreeNode(20);
        TreeNode node15 = new TreeNode(15, node11, node20);

        TreeNode node10 = new TreeNode(10, node5, node15);

        BSTIterator b = new BSTIterator(node10);
        /*
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2, node1, null);
        BSTIterator bSTIterator = new BSTIterator(node2);
        System.out.println(bSTIterator.hasNext());
        System.out.println(bSTIterator.next());
        System.out.println(bSTIterator.hasNext());
        System.out.println(bSTIterator.next());
        System.out.println(bSTIterator.hasNext());
        */
    }
}