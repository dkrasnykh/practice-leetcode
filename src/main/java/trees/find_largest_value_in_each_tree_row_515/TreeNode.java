package trees.find_largest_value_in_each_tree_row_515;

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
    public List<Integer> largestValues(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) return result;
        ArrayDeque<TreeNode> q = new ArrayDeque<>();
        q.addLast(root);
        while(!q.isEmpty()){
            int localMax = Integer.MIN_VALUE;
            int size = q.size();
            for(int i = 0; i < size; ++i){
                TreeNode cur = q.pollFirst();
                localMax = Math.max(localMax, cur.val);
                if(cur.left != null){
                    q.addLast(cur.left);
                }
                if(cur.right != null){
                    q.addLast(cur.right);
                }
            }
            result.add(localMax);
        }
        return result;
    }
}
