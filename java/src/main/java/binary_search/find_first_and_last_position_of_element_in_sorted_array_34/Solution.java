package binary_search.find_first_and_last_position_of_element_in_sorted_array_34;

import java.util.Arrays;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length == 0) return new int[]{-1, -1};
        int l = 0, r = nums.length - 1;
        int[] ans = new int[2];
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] >= target) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        ans[0] = (l < nums.length && nums[l] == target) ? l : -1;
        l = 0;
        r = nums.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (nums[m] <= target) {
                l = m + 1;
            } else {
                r = m - 1;
            }
        }
        ans[1] = (r >= 0 && nums[r] == target) ? r : -1;
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));

    }
}
