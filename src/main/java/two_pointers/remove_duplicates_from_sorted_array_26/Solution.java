package two_pointers.remove_duplicates_from_sorted_array_26;

import java.util.Arrays;

public class Solution {
    public int removeDuplicates(int[] nums) {
        int l = 1;
        for (int r = 1; r < nums.length; ++r) {
            if (nums[r] != nums[r - 1]) {
                nums[l] = nums[r];
                l += 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        System.out.println(s.removeDuplicates(nums));
        System.out.println(Arrays.toString(nums));

    }
}
