package trees.binary_tree_inorder_traversal_94;

import java.util.ArrayList;
import java.util.List;
class TreeNode {
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
 /*
static void inorderTreeWalk(Node x) {
        if (x != null) {
            inorderTreeWalk(x.left);
            System.out.println(x.key);
            inorderTreeWalk(x.right);
        }
}
*/
class Solution {
    private void traversal(List<Integer> res,TreeNode root){
        if(root!=null){
            traversal(res, root.left);
            res.add(root.val);
            traversal(res, root.right);
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traversal(res, root);
        return res;
    }
    public static void main(String[] args) {

    }
}
