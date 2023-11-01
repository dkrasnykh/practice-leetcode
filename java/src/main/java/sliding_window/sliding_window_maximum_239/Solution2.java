package sliding_window.sliding_window_maximum_239;

import java.util.ArrayDeque;

public class Solution2 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] result = new int[nums.length - k + 1];
        ArrayDeque<Integer> deq = new ArrayDeque<>();
        int l = 0, i = 0;
        for (int r = 0; r < nums.length; ++r) {
            while (!deq.isEmpty() && nums[deq.getLast()] < nums[r]) {
                deq.pollLast();
            }
            deq.addLast(r);
            if (l > deq.getFirst()) {
                deq.pollFirst();
            }
            if(r + 1 >= k){
                result[i] = nums[deq.getFirst()];
                i += 1;
                l += 1;
            }
        }
        return result;
    }
}
