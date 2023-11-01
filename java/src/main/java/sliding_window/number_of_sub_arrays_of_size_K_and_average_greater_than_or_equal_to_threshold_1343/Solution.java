package sliding_window.number_of_sub_arrays_of_size_K_and_average_greater_than_or_equal_to_threshold_1343;

import java.util.ArrayDeque;

public class Solution {
    public int numOfSubarrays(int[] arr, int k, int threshold) {
        int total = 0;
        int l = 0;
        int res = 0;
        for (int r = 0; r < arr.length; ++r) {
            total += arr[r];
            if (r - l + 1 == k) {
                if (total / k >= threshold) {
                    res += 1;
                }
                total -= arr[l];
                l += 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        //arr = [2,2,2,2,5,5,5,8], k = 3, threshold = 4
        Solution s = new Solution();
        System.out.println(s.numOfSubarrays(new int[]{2, 2, 2, 2, 5, 5, 5, 8}, 3, 4));
    }
}
