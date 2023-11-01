package sliding_window.longest_subarray_of_1s_after_deleting_one_element_1493;

import java.util.List;
import java.util.ArrayList;

public class Solution {
    public int longestSubarray(int[] nums) {
        List<int[]> segm1 = new ArrayList<>();
        int i = 0;
        while(i < nums.length){
            int l = i;
            while(i < nums.length && nums[i] == 1){
                i += 1;
            }
            if(l != i){
                segm1.add(new int[]{l, i});
            }
            i += 1;
        }
        if(segm1.size() == 0){
            return 0;
        } else if (segm1.size() == 1 && segm1.get(0)[1] - segm1.get(0)[0] == nums.length){
            return segm1.get(0)[1] - segm1.get(0)[0] - 1;
        } else if (segm1.size() == 1){
            return segm1.get(0)[1] - segm1.get(0)[0];
        } else {
            int maxLen = segm1.get(0)[1] - segm1.get(0)[0];
            for(i = 1; i < segm1.size(); ++i){
                if(segm1.get(i)[0] - segm1.get(i-1)[1] == 1){
                    maxLen = Math.max(maxLen, segm1.get(i)[1] - segm1.get(i)[0] + (segm1.get(i-1)[1] - segm1.get(i-1)[0]));
                } else {
                    maxLen = Math.max(maxLen, segm1.get(i)[1] - segm1.get(i)[0]);
                }
            }
            return maxLen;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.longestSubarray(new int[]{0,1,1,1,0,0,1,1,0}));
    }
}
