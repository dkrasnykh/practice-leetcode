package sliding_window.minimum_size_subarray_sum_209;

//https://www.youtube.com/watch?v=aYqYMIqZx5s
public class Solution2 {
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, total = 0;
        int res = Integer.MAX_VALUE;
        for (int r = 0; r < nums.length; ++r) {
            total += nums[r];
            while (total >= target) {
                res = Math.min(r - l + 1, res);
                total -= nums[l];
                l += 1;
            }
        }
        return (res == Integer.MAX_VALUE ? 0 : res);
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
        System.out.println(s.minSubArrayLen(4, new int[]{1, 4, 4}));
        System.out.println(s.minSubArrayLen(11, new int[]{1, 1, 1, 1, 1, 1, 1, 1}));
    }
}
