package array.number_of_zero_filled_subarrays_2348;

//https://www.youtube.com/watch?v=G-EWVGCcL_w
public class Solution1 {
    public long zeroFilledSubarray(int[] nums) {
        int i = 0;
        long res = 0;
        while(i < nums.length){
            long count = 0;
            while(i < nums.length && nums[i] == 0){
                count += 1;
                i += 1;
                res += count;
            }
            i += 1;
        }
        return res;
    }
}
