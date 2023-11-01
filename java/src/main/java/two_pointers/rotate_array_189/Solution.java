package two_pointers.rotate_array_189;

import java.util.Arrays;

//https://www.youtube.com/watch?v=BHr381Guz3Y
public class Solution {
    private void reverse(int[] nums, int l, int r) {
        while (l < r) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l += 1;
            r -= 1;
        }
    }

    public void rotate(int[] nums, int k) {
        k = k % nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {1, 2, 3, 4, 5, 6};
        s.rotate(nums, 4);
        System.out.println(Arrays.toString(nums));
    }
}
