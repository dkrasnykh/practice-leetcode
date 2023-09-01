package array.summary_ranges_228;

import java.util.List;
import java.util.ArrayList;

public class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        if(nums.length == 0) return res;
        int start = nums[0], i = 1;
        while(i < nums.length){
            int l = i;
            while(i < nums.length && nums[i] - 1 == nums[i - 1]){
                i += 1;
            }
            if(l == i){
                res.add(Integer.toString(start));
            } else {
                res.add(start + "->" + nums[i - 1]);
            }
            start = i < nums.length ? nums[i] : start;
            i += 1;
        }
        if(start == nums[nums.length - 1]){
            res.add(Integer.toString(start));
        }
        return res;
    }
}
