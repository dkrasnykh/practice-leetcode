package arrays_hashing.sign_of_the_product_of_an_array_1822;

public class Solution {
    public int arraySign(int[] nums) {
        int negative = 0;
        for(int i = 0; i < nums.length; ++i){
            if(nums[i] == 0){
                return 0;
            }
            if(nums[i] < 0){
                negative += 1;
            }
        }
        if(negative % 2 == 1){
            return -1;
        }
        return 1;
    }
}
