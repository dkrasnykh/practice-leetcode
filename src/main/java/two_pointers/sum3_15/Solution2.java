package two_pointers.sum3_15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.youtube.com/watch?v=jzZsG8n2R9A
public class Solution2 {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        for(int i = 0; i < nums.length; ++i){
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int l = i+1, r = nums.length-1;
            while(l < r){
                int threeSum = nums[i] + nums[l] + nums[r];
                if(threeSum > 0){
                    r -= 1;
                } else if (threeSum < 0){
                    l += 1;
                } else {
                    res.add(Arrays.asList(nums[i], nums[l], nums[r]));
                    l += 1;
                    while(nums[l] == nums[l - 1] && l < r){
                        l += 1;
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
