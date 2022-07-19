package array.twoSum;

import java.util.*;

/*
https://leetcode.com/problemset/all/?topicSlugs=array
#1. Two sum
 */

public class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], i);
        }
        for(int i = 0; i < nums.length; i++){
            int number = target - nums[i];
            if (map.containsKey(number) && map.get(number) != i) {
                return new int[]{i, map.get(number)};
            }
        }
        throw new IllegalStateException();
    }
}
