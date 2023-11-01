package arrays_hashing.concatenation_of_array_1929;

import java.util.Arrays;

public class Solution {
    public int[] getConcatenation(int[] nums) {
        int n = nums.length;
        int[] ans = new int[2 * n];
        for (int i = 0; i < n; ++i) {
            ans[i] = ans[i + n] = nums[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        /*
        Input: nums = [1,2,1]
        Output: [1,2,1,1,2,1]
        */
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.getConcatenation(new int[]{1, 3, 2, 1})));

    }
}
