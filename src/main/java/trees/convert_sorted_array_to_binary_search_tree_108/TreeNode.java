package trees.convert_sorted_array_to_binary_search_tree_108;

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
    private void buildBST(int[] nums, int l, int r, TreeNode previous) {
        if(l > r){
            return;
        }
        int m = l + (r - l + 1) / 2;
        TreeNode cur = new TreeNode(nums[m]);
        if (previous.val <= nums[m]) {
            previous.right = cur;
        } else {
            previous.left = cur;
        }
        buildBST(nums, l, m - 1, cur);
        buildBST(nums, m + 1, r, cur);
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        int m = nums.length / 2;
        TreeNode root = new TreeNode(nums[m]);
        buildBST(nums, 0, m - 1, root);
        buildBST(nums, m + 1, nums.length - 1, root);
        return root;
    }

    public static void main(String[] args) {
        System.out.println(1/2);
        Solution s = new Solution();
        TreeNode res = s.sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
        int test = 5;
    }
}
