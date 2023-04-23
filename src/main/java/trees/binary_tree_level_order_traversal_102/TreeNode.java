package trees.binary_tree_level_order_traversal_102;

import java.util.ArrayDeque;
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null) return res;
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        while(!q.isEmpty()){
            int lenght = q.size();
            List<Integer> level = new ArrayList<>();
            for(int i = 0; i < lenght; ++i){
                TreeNode node = q.pollFirst();
                if(node.left!=null){
                    q.addLast(node.left);
                }
                if(node.right!=null){
                    q.addLast(node.right);
                }
                level.add(node.val);
            }
            res.add(level);
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
