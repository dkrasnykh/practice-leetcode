package sliding_window.frequency_of_the_most_frequent_element_1838;

import java.util.Arrays;

//https://www.youtube.com/watch?v=vgBrQ0NM5vE
public class Solution1 {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, r = 0;
        long total = 0;
        int res = 0;
        while (r < nums.length) {
            total += nums[r];
            while ((long) nums[r] * (r - l + 1) > total + k) {
                total -= nums[l];
                l += 1;
            }
            res = Math.max(res, r - l + 1);
            r += 1;
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
