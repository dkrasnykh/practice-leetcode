package array.majority_element_169;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> cnt = new HashMap<>();
        int majority = nums[0];
        int maxlen = 0;
        for(int i = 0; i<nums.length; ++i){
            cnt.compute(nums[i], (key, value)->value==null ? 1 : value+1);
            if(maxlen < cnt.get(nums[i])){
                majority = nums[i];
                maxlen = cnt.get(nums[i]);
            }
        }
        return majority;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.majorityElement(new int[]{2,2,1,1,1,2,2}));
        System.out.println(s.majorityElement(new int[]{3,2,3}));
        //[6,6,6,7,7]
        System.out.println(s.majorityElement(new int[]{6,6,6,7,7}));
    }
}
