package array.find_all_numbers_disappeared_in_an_array_448;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (Integer n : nums) {
            int i = Math.abs(n) - 1;
            nums[i] = -1 * Math.abs(nums[i]);
        }
        List<Integer> ans = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] > 0) {
                ans.add(i + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2, 3, 1}));

    }
}
