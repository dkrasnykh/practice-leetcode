package two_pointers.array_with_elements_not_equal_to_average_of_neighbors_1968;

import java.util.Arrays;

public class Solution1 {
    public int[] rearrangeArray(int[] nums) {
        Arrays.sort(nums);
        int l = 1, r = (nums.length % 2 == 0) ? nums.length - 2 : nums.length - 1;
        while (l < r) {
            int tmp = nums[l];
            nums[l] = nums[r];
            nums[r] = tmp;
            l += 2;
            r -= 2;
        }
        return nums;
    }

    public static void main(String[] args) {
        Solution1 s = new Solution1();
        System.out.println(Arrays.toString(s.rearrangeArray(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(s.rearrangeArray(new int[]{6, 2, 0, 9, 7})));
    }
}
