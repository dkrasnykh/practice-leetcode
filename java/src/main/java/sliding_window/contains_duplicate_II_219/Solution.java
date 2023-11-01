package sliding_window.contains_duplicate_II_219;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> last = new HashMap<>();
        for(int i = 0; i<nums.length; ++i){
            if(last.containsKey(nums[i]) && i - last.get(nums[i]) <= k){
                    return true;
            }
            last.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
