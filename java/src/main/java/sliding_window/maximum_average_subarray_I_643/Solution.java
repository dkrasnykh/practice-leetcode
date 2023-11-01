package sliding_window.maximum_average_subarray_I_643;

public class Solution {
    public double findMaxAverage(int[] nums, int k) {
        double result = Integer.MIN_VALUE;
        int total = 0;
        int l = 0;
        for(int r = 0; r < nums.length; ++r){
            total += nums[r];
            if(r - l + 1 > k){
                total -= nums[l];
                l += 1;
            }
            if(r - l + 1 == k){
                result = Math.max(result, (1.0)*total/k);
            }
        }
        return result;
    }
}
