package arrays_hashing.product_of_array_except_self_238;

import java.util.Arrays;

public class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];
        ans[n - 1] = nums[n - 1];
        for (int i = nums.length - 2; i >= 0; --i) {
            ans[i] = ans[i + 1] * nums[i];
        }
        int prefix = 1;
        for (int i = 0; i < n - 1; ++i) {
            ans[i] = prefix * ans[i + 1];
            prefix *= nums[i];
        }
        ans[n - 1] = prefix;
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.productExceptSelf(new int[]{1, 2, 3, 4})));
        System.out.println(Arrays.toString(s.productExceptSelf(new int[]{-1, 1, 0, -3, 3})));
    }
}
