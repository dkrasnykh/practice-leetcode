package sliding_window.frequency_of_the_most_frequent_element_1838;

import java.util.Arrays;

public class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int frequency = 1;
        int l = 0, r = 1;
        while (r < nums.length) {
            if (l == r) {
                r += 1;
            } else {
                int n = (nums[r] - nums[r - 1]) * (r - l);
                if (k - n >= 0) {
                    k -= n;
                    frequency = Math.max(frequency, r - l + 1);
                    r += 1;
                } else {
                    k += (nums[r - 1] - nums[l]);
                    l += 1;
                }
            }
        }
        return frequency;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.maxFrequency(new int[]{1, 2, 4}, 5));
        System.out.println(s.maxFrequency(new int[]{1, 4, 8, 13}, 5));
        System.out.println(s.maxFrequency(new int[]{3, 9, 6}, 2));
    }
}
