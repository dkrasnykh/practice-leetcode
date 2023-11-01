package trees.find_bottom_left_tree_value_513.solution1;

import java.util.ArrayDeque;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public int findBottomLeftValue(TreeNode root) {
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        TreeNode left = null;
        while(!q.isEmpty()){
            left = null;
            int l = q.size();
            while(l > 0){
                TreeNode tmp = q.pollFirst();
                if(left == null){
                    left = tmp;
                }
                l -= 1;
                if(tmp.left != null){
                    q.addLast(tmp.left);
                }
                if(tmp.right != null){
                    q.addLast(tmp.right);
                }
            }

        }
        return left.val;
    }

    public static void main(String[] args) {

    }
}