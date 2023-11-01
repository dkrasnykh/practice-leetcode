package binary_search.find_minimum_in_rotated_sorted_array_153;

public class Solution {
    public int findMin(int[] nums) {
        int l = 1, r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] < nums[m - 1]) {
                return nums[m];
            } else if (nums[m] < nums[0]) {
                r = m - 1;
            } else if (nums[m] > nums[0]) {
                l = m + 1;
            }
        }
        return nums[0];
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findMin(new int[]{3, 4, 5, 1, 2}));
        System.out.println(s.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        System.out.println(s.findMin(new int[]{11, 13, 15, 17}));
    }
}
