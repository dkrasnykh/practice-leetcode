package array.nextPermutation;

import java.util.Arrays;

public class Solution {
    public void nextPermutation(int[] nums) {
        int size = nums.length - 1;
        while (size > 0) {
            if (nums[size] > nums[size - 1]) {
                break;
            }
            size--;
        }
        if (size == 0) {
            Arrays.sort(nums);
            return;
        }
        int[] temp = new int[nums.length - size];
        System.arraycopy(nums, size, temp, 0, nums.length - size);
        Arrays.sort(temp);
        for (int i = 0; i < temp.length; i++) {
            if (temp[i] > nums[size - 1]) {
                int k = nums[size - 1];
                nums[size - 1] = temp[i];
                temp[i] = k;
                break;
            }
        }
        Arrays.sort(temp);
        for (int i = size; i < nums.length; i++) {
            nums[i] = temp[i - size];
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.nextPermutation(new int[]{0, 1, 2, 5, 3, 3, 0});
        //solution.nextPermutation(new int[]{2, 3, 1});
        //solution.nextPermutation(new int[]{3, 2, 1});
    }
}
