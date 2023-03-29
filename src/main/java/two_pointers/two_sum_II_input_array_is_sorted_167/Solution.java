package two_pointers.two_sum_II_input_array_is_sorted_167;

import java.util.Arrays;

public class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0, r = numbers.length - 1;
        while (l < r) {
            if (numbers[l] + numbers[r] > target) {
                r -= 1;
            } else if (numbers[l] + numbers[r] < target) {
                l += 1;
            } else {
                return new int[]{l + 1, r + 1};
            }
        }
        return new int[]{};
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.twoSum(new int[]{2, 7, 11, 15}, 9)));

    }
}
