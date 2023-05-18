package array.continuous_subarray_sum_523;


import java.util.*;

//https://www.youtube.com/watch?v=OKcrLfR-8mE
public class Solution2 {
    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Integer, Integer> reminder = new HashMap<>();
        reminder.put(0, -1);
        int total = 0;
        for(int i = 0; i<nums.length; ++i){
            total += nums[i];
            int r = total % k;
            if(!reminder.containsKey(r)){
                reminder.put(r, i);
            } else if (i - reminder.get(r) > 1){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {

    }
}
