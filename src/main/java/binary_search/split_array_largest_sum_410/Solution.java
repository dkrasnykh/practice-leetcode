package binary_search.split_array_largest_sum_410;

public class Solution {
    private boolean isSplittable(int limit, int[] nums, int k) {
        int sum = 0;
        int n = 0;
        for (int i = 0; i < nums.length; ++i) {
            sum += nums[i];
            if (sum > limit) {
                n += 1;
                sum = nums[i];
            }
        }
        return n + 1 <= k;
    }

    public int splitArray(int[] nums, int k) {
        int l = 0, r = 0;
        for (int i = 0; i < nums.length; ++i) {
            l = Math.max(l, nums[i]);
            r += nums[i];
        }
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (isSplittable(m, nums, k)) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        //System.out.println(s.check(18, new int[]{7, 2, 5, 10, 8}, 2));
        System.out.println(s.splitArray(new int[]{7, 2, 5, 10, 8}, 2));

    }
}
