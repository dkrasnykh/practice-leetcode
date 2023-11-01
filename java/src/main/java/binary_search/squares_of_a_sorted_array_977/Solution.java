package binary_search.squares_of_a_sorted_array_977;

import java.util.Arrays;

public class Solution {
    public int[] sortedSquares(int[] nums) {
        int l = 0;
        for(int i = 0; i<nums.length; ++i){
            if(Math.abs(nums[i])<Math.abs(nums[l])){
                l = i;
            }
        }
        int[] res = new int[nums.length];
        res[0] = nums[l] * nums[l];
        int r = l + 1;
        l -= 1;
        int j = 1;
        while (l >= 0 || r < nums.length) {
            if (r == nums.length || l >= 0 && Math.abs(nums[l]) < Math.abs(nums[r])) {
                res[j] = nums[l] * nums[l];
                l -= 1;
            } else {
                res[j] = nums[r] * nums[r];
                r += 1;
            }
            j += 1;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        /*
        System.out.println(Arrays.toString(s.sortedSquares(new int[]{-4, -1, 0, 3, 10})));
        System.out.println(Arrays.toString(s.sortedSquares(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(s.sortedSquares(new int[]{-5, -4, -3, -2, -1})));
        System.out.println(Arrays.toString(s.sortedSquares(new int[]{-5, -4, -3, -2, -1, 1})));
        System.out.println(Arrays.toString(s.sortedSquares(new int[]{-4,-4,-3})));
        */
        System.out.println(Arrays.toString(s.sortedSquares(new int[]{2,3,3,4})));
    }
}
