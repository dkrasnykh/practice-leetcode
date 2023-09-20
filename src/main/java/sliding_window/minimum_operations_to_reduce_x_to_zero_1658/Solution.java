package sliding_window.minimum_operations_to_reduce_x_to_zero_1658;

import java.util.Arrays;

public class Solution {
    public int minOperations(int[] nums, int x) {
        int windowSum = Arrays.stream(nums).sum() - x;
        if(windowSum < 0) return -1;
        if(windowSum == 0) return nums.length;
        int maxSize = -1, total = 0;
        int l = 0;
        for (int r = 0; r < nums.length; ++r) {
            total += nums[r];
            while (l < r && total > windowSum) {
                total -= nums[l];
                l += 1;
            }
            if (total == windowSum) {
                maxSize = Math.max(maxSize, r - l + 1);
            }
        }
        return (maxSize == -1 ? maxSize : nums.length - maxSize);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        /*
        System.out.println(s.minOperations(new int[]{1,1,4,2,3}, 5));
        System.out.println(s.minOperations(new int[]{5,6,7,8,9}, 4));
        System.out.println(s.minOperations(new int[]{3,2,20,1,1,3}, 10));
        System.out.println(s.minOperations(new int[]{1}, 1));
        */
        //[8828,9581,49,9818,9974,9869,9991,10000,10000,10000,9999,9993,9904,8819,1231,6309]  x = 134365
        System.out.println(s.minOperations(new int[]{8828,9581,49,9818,9974,9869,9991,10000,10000,10000,9999,9993,9904,8819,1231,6309}, 134365));

    }
}
