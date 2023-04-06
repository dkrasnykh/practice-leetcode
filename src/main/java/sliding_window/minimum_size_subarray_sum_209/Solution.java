package sliding_window.minimum_size_subarray_sum_209;

public class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int total = 0;
        int l = 0, r = 0;
        int min = nums.length + 1;
        while (r <= nums.length) {
            if (total >= target) {
                min = Math.min(min, r - l);
                total -= nums[l];
                l += 1;
            } else {
                total += ((r < nums.length) ? nums[r] : 0);
                r += 1;
            }
        }
        //min = (total >= target) ? Math.min(min, r - l) : min;
        return (min == nums.length + 1) ? 0 : min;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(s.minSubArrayLen(4, new int[]{1, 4, 4}));
        System.out.println(s.minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
    }
}
