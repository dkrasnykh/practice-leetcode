package arrays_hashing.number_of_zero_filled_subarrays_2348;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long total = 0;
        Map<Integer, Integer> segm = new HashMap<>();
        int start = 0;
        int maxLen = 0;
        for(int i = 1; i < nums.length; ++i){
            if(nums[i] == 0 && nums[i - 1] != 0){
                start = i;
            }
            if(nums[i] != 0 && nums[i - 1] == 0){
                int key = i - start;
                maxLen = Math.max(maxLen, key);
                segm.compute(key, (k,v)->(v==null)?1:v+1);
            }
        }
        if(nums[nums.length - 1] == 0){
            int key = nums.length - start;
            maxLen = Math.max(maxLen, key);
            segm.compute(key, (k,v)->(v==null)?1:v+1);
        }
        long[] dp = new long[maxLen + 1];
        for(int i = 1; i <= maxLen; ++i){
            dp[i] = dp[i - 1] + i;
        }
        for(Map.Entry<Integer, Integer> e : segm.entrySet()){
            total += dp[e.getKey()]*e.getValue();
        }
        return total;
    }
}
