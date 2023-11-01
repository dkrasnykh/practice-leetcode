package arrays_hashing.first_missing_positive_41;

//https://www.youtube.com/watch?v=8g78yfzMlao
public class Solution1 {

    public int firstMissingPositive(int[] nums) {
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] < 0){
                nums[i] = 0;
            }
        }
        for(int i = 0; i < nums.length; ++i){
            int val = Math.abs(nums[i]);
            if (val >= 1 && val <= nums.length) {
                if(nums[val - 1] > 0){
                    nums[val - 1] *= -1;
                } else if (nums[val - 1] == 0) {
                    nums[val - 1] = -1 * (nums.length + 1);
                }
            }
        }
        for(int i = 1; i <= nums.length; ++i){
            if(nums[i-1] >= 0){
                return i;
            }
        }
        return nums.length + 1;
    }

    public static void main(String[] args) {

    }
}
