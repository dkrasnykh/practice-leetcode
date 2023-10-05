package arrays_hashing.sort_colors_75;

import java.util.Arrays;

public class Solution {
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    public void sortColors(int[] nums) {
        int l = 0;
        int r = nums.length - 1;
        int i = 0;
        while (i <= r) {
            if (nums[i] == 0) {
                swap(nums, i, l);
                l += 1;
                if (i < l || nums[i] == 1) {
                    i += 1;
                }
            } else if (nums[i] == 1) {
                i += 1;
            } else if (nums[i] == 2) {
                swap(nums, i, r);
                r -= 1;
                if (i > r || nums[i] == 1) {
                    i += 1;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = {2, 0, 2, 1, 1, 0};
        s.sortColors(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{2, 0, 1};
        s.sortColors(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{1, 2, 1, 2, 1, 2 , 0, 1};
        s.sortColors(nums);
        System.out.println(Arrays.toString(nums));
        //nums = new int[]{2, 0, 0, 0, 0, 0, 0, 0, 1}; // - ошибка
        nums = new int[]{2, 0, 0, 1}; // - ошибка
        s.sortColors(nums);
        System.out.println(Arrays.toString(nums));
        //когда есть только 1 цвет
        nums = new int[]{0, 0, 0, 0, 0, 0};
        s.sortColors(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{1, 1, 1, 1, 1, 1};
        s.sortColors(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{2, 2, 2, 2, 2, 2};
        s.sortColors(nums);
        System.out.println(Arrays.toString(nums));
        //когда есть только 2 цвета
        nums = new int[]{0, 1, 0, 1, 0, 1, 1};
        s.sortColors(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{2,  1, 1, 1, 2, 2};
        s.sortColors(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{2, 0, 2, 2, 0, 0, 0};
        s.sortColors(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{0};
        s.sortColors(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{1};
        s.sortColors(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{2};
        s.sortColors(nums);
        System.out.println(Arrays.toString(nums));
        nums = new int[]{2, 2, 2, 2, 2, 2, 0};
        s.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
