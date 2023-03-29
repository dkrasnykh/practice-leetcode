package two_pointers.sum4_18;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            long targetForThree = target - nums[i];
            for (int j = i + 1; j < nums.length; ++j) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                int l = j + 1, r = nums.length - 1;
                while(l < r){
                    long total = (long)nums[j] + (long)nums[l] + (long)nums[r];
                    if(total > targetForThree){
                        r -= 1;
                    } else if (total < targetForThree){
                        l += 1;
                    } else {
                        res.add(Arrays.asList(nums[i], nums[j], nums[l], nums[r]));
                        l+=1;
                        while(l<r && nums[l] == nums[l - 1]){
                            l += 1;
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> ans = s.fourSum(new int[]{1000000000,1000000000,1000000000,1000000000}, -294967296);
        for(List<Integer> e : ans){
            System.out.println(e.toString());
        }

    }
}
