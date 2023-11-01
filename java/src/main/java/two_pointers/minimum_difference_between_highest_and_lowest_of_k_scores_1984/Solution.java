package two_pointers.minimum_difference_between_highest_and_lowest_of_k_scores_1984;

import java.util.Arrays;

public class Solution {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = k - 1;
        int ans = nums[nums.length - 1];
        while (r < nums.length) {
            ans = Math.min(nums[r] - nums[l], ans);
            l += 1;
            r += 1;
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
