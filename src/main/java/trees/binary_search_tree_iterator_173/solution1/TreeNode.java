package trees.binary_search_tree_iterator_173.solution1;

import java.util.ArrayDeque;

//https://www.youtube.com/watch?v=RXy5RzGF5wo
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
    ArrayDeque<TreeNode> stack;

    public BSTIterator(TreeNode root) {
        stack = new ArrayDeque<>();
        while(root != null){
            stack.addLast(root);
            root = root.left;
        }
    }

    public int next() {
        TreeNode res = stack.pollLast();
        TreeNode cur = res.right;
        while(cur != null){
            stack.addLast(cur);
            cur = cur.left;
        }
        return res.val;
    }

    public boolean hasNext() {
        return !stack.isEmpty();
    }

}
