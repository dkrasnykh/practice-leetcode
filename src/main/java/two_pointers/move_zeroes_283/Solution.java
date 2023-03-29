package two_pointers.move_zeroes_283;

import java.util.Arrays;

public class Solution {
    public void moveZeroes(int[] nums) {
        int i = 0, p = 0;
        while (i < nums.length) {
            if (nums[i] == 0) {
                if (p < i) {
                    p = i + 1;
                }
                while (p < nums.length && nums[p] == 0) {
                    p += 1;
                }
                if (p == nums.length) {
                    return;
                }
                nums[i] = nums[p];
                nums[p] = 0;
                p += 1;
            }
            i += 1;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {0, 1, 0, 3, 12};
        s.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
