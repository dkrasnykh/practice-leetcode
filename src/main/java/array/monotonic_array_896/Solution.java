package array.monotonic_array_896;

class Solution {
    private boolean isIncreasing(int[] nums){
        for(int i = 1; i < nums.length; ++i){
            if(nums[i] < nums[i - 1]){
                return false;
            }
        }
        return true;
    }

    private boolean isDecreasing(int[] nums){
        for(int i = 1; i < nums.length; ++i){
            if(nums[i] > nums[i - 1]){
                return false;
            }
        }
        return true;
    }

    public boolean isMonotonic(int[] nums) {
        return isIncreasing(nums) || isDecreasing(nums);
    }
}
