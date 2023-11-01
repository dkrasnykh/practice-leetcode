package arrays_hashing.number_of_good_pairs_1512;

import java.util.Map;
import java.util.HashMap;

public class Solution {
    public int numIdenticalPairs(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        for(int i = nums.length - 1; i >= 0; --i){
            result += map.getOrDefault(nums[i], 0);
            map.compute(nums[i], (k,v) -> v == null ? 1 : v + 1);
        }
        //c*(c - 1)/2 - count of good pairs, where c is the number of num
        return result;
    }
}
