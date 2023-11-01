package sliding_window.subarray_product_less_than_k_713;

public class Solution {
    private int cnt(int k) {
        return (1 + k) * k / 2;
    }

    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int product = 1, l = 0, result = 0;
        for (int r = 0; r < nums.length; ++r) {
            while (l < r && product * nums[r] >= k) {
                product /= nums[l];
                l += 1;
            }
            if (product * nums[r] >= k) {
                l += 1;
            } else {
                product *= nums[r];
                result += (cnt(r - l + 1) - cnt(r - l));
            }
        }
        return result;
    }
}
