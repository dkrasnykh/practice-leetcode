package array.missing_number_268;

public class Solution {
    public int missingNumber(int[] nums) {
        boolean zeroVisited = false;
        for(int i = 0; i < nums.length; ++i){
            if(Math.abs(nums[i]) < nums.length && nums[Math.abs(nums[i])] == 0){
                zeroVisited = true;
            } else if (Math.abs(nums[i]) < nums.length){
                nums[Math.abs(nums[i])] *= (-1);
            }
        }
        int result = nums.length;
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] == 0 && !zeroVisited || nums[i] > 0){
                result = i;
            }
        }
        return result;
    }
}
