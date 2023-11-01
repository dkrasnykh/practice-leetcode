package two_pointers.array_with_elements_not_equal_to_average_of_neighbors_1968;

import java.util.Arrays;

public class Solution {
    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);
        int[] ans = new int[nums.length];
        int p = 0;
        for (int i = 1; i < nums.length; i += 2) {
            ans[i] = nums[p];
            p += 1;
        }
        for(int i = 0; i<nums.length; i+=2){
            ans[i] = nums[p];
            p += 1;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.rearrangeArray(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(s.rearrangeArray(new int[]{6, 2, 0, 9, 7})));
    }
}
