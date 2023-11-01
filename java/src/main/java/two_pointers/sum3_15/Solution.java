package two_pointers.sum3_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int i = 0;
        while (i < nums.length) {
            int l = i + 1, r = nums.length - 1;
            while (l < r) {
                if (l > i + 1 && nums[l - 1] == nums[l]) {
                    l += 1;
                } else if (r < nums.length-1 && nums[r] == nums[r+1]){
                    r -= 1;
                } else if (nums[i] + nums[l] + nums[r] > 0) {
                    r -= 1;
                } else if (nums[i] + nums[l] + nums[r] < 0) {
                    l += 1;
                } else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l += 1;
                    r -= 1;
                }
            }
            i += 1;
            while (i < nums.length && nums[i] == nums[i - 1]) {
                i += 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> ans = s.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        //List<List<Integer>> ans = s.threeSum(new int[]{-1, 0, 0, 0, 1, 1, 1});
        for (List<Integer> e : ans) {
            System.out.println(e.toString());
        }
    }
}
