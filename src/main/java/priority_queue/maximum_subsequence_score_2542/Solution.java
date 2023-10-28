package priority_queue.maximum_subsequence_score_2542;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

//https://www.youtube.com/watch?v=ax1DKi5lJwk
public class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        List<int[]> pair = new ArrayList<>();
        for (int i = 0; i < nums1.length; ++i) {
            pair.add(new int[]{nums1[i], nums2[i]});
        }
        pair.sort((a, b) -> a[1] == b[1] ? a[0] - b[0] : b[1] - a[1]);
        PriorityQueue<Long> pq = new PriorityQueue<>();
        long n1Sum = 0, result = 0;
        for (int[] p : pair) {
            long n1 = p[0], n2 = p[1];
            n1Sum += n1;
            pq.add(n1);
            if (pq.size() > k) {
                long n1Pop = pq.poll();
                n1Sum -= n1Pop;
            }
            if (pq.size() == k) {
                result = Math.max(result, n1Sum * n2);
            }
        }
        return result;
    }
}
