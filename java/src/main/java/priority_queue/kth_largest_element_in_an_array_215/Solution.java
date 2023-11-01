package priority_queue.kth_largest_element_in_an_array_215;

import java.util.PriorityQueue;

public class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (Integer n : nums) {
            q.add(n);
            if (q.size() > k) {
                q.poll();
            }
        }
        return q.poll();
    }
}
