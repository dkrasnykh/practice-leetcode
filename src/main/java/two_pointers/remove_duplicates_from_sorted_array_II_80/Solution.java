package two_pointers.remove_duplicates_from_sorted_array_II_80;

import java.util.Arrays;

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int l = 2;
        for (int r = 2; r < nums.length; ++r) {
            if (nums[r] != nums[l - 1] || nums[r] != nums[l - 2]) {
                nums[l] = nums[r];
                l += 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {0, 0, 1, 1, 1, 1, 2, 3, 3};
        System.out.println(s.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));
    }
}
