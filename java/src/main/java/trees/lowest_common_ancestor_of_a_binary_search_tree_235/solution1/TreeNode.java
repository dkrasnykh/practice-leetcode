package trees.lowest_common_ancestor_of_a_binary_search_tree_235.solution1;

//https://www.youtube.com/watch?v=gs2LMfuOR9k
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode cur = root;
        while(cur != null){
            if(p.val > cur.val && q.val > cur.val){
                cur = cur.right;
            } else if (p.val < cur.val && q.val < cur.val){
                cur = cur.left;
            } else {
                return cur;
            }
        }
        return null;
    }
    public static void main(String[] args) {

    }
}
