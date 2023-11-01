package binary_search.search_insert_position_35;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while (l < r) {
            int m = (l + r) / 2;
            if (nums[m] >= target) {
                r = m;
            } else {
                l = m + 1;
            }
        }
        if (target > nums[l]) {
            return l + 1;
        } else {
            return l;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        //[1,3,5,6], target = 5
        System.out.println(s.searchInsert(new int[]{1, 3, 5, 6}, -1));
    }
}
