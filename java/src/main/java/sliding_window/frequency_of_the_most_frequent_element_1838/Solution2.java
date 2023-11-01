package sliding_window.frequency_of_the_most_frequent_element_1838;

import java.util.Arrays;

public class Solution2 {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int l = 0, answer = 1;
        for(int r = 1; r < nums.length; ++r){
            int down = (nums[r] - nums[r - 1])*(r - l);
            k -= down;
            if(k >= 0){
                answer = Math.max(answer, r - l + 1);
            } else {
                while(k < 0 && l <= r){
                    k += (nums[r] - nums[l]);
                    l += 1;
                }

            }
        }
        return answer;
    }
}
