package sliding_window.contains_duplicate_II_219;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://www.youtube.com/watch?v=ypn0aZ0nrL4
public class Solution1 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> window = new HashSet<>();
        int l = 0;
        for(int r = 0; r < nums.length; ++r){
            if (r - l > k){
                window.remove(nums[l]);
                l += 1;
            }
            if(window.contains(nums[r])){
                return true;
            }
            window.add(nums[r]);
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
