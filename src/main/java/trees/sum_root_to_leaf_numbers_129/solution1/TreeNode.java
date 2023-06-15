package trees.sum_root_to_leaf_numbers_129.solution1;

//https://www.youtube.com/watch?v=Jk16lZGFWxE
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
    private int dfs(TreeNode cur, int num) {
        if (cur == null) {
            return 0;
        }
        num = num * 10 + cur.val;
        if (cur.left == null && cur.right == null) {
            return num;
        }
        return dfs(cur.left, num) + dfs(cur.right, num);
    }

    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    public static void main(String[] args) {

    }
}