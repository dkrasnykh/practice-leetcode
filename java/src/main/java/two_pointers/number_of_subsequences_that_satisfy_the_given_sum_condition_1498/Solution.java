package two_pointers.number_of_subsequences_that_satisfy_the_given_sum_condition_1498;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//TL - 15 тест
public class Solution {
    public long cnt;
    public List<Integer> subset;
    public void generateSunset(int k, int n, int[] nums, int target){
        if(k==n+1){
            if(!subset.isEmpty() && subset.get(0) + subset.get(subset.size()-1) <= target){
                cnt++;
            }
        } else {
            subset.add(nums[k]);
            generateSunset(k+1, n, nums, target);
            Integer o = subset.get(subset.size()-1);
            subset.remove(o);
            generateSunset(k+1, n, nums, target);
        }
    }
    public int numSubseq(int[] nums, int target) {
        cnt = 0;
        subset = new ArrayList<>();
        Arrays.sort(nums);
        generateSunset(0, nums.length-1, nums, target);
        return (int)(cnt%1000000007);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.numSubseq(new int[]{2, 3, 3, 4, 6, 7}, 12));
    }
}
