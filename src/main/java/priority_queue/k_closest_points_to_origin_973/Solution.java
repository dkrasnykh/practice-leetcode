package priority_queue.k_closest_points_to_origin_973;

import java.util.PriorityQueue;

public class Solution {
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> q = new PriorityQueue<>((e1, e2) -> e1[0] == e2[0] ? e1[1] - e2[1] : e1[0] - e2[0]);
        for (int i = 0; i < points.length; ++i) {
            q.add(new int[]{points[i][0] * points[i][0] + points[i][1] * points[i][1], i});
        }
        int[][] result = new int[k][2];
        for (int i = 0; i < k; ++i) {
            int[] p = q.poll();
            result[i] = points[p[1]];
        }
        return result;
    }
}
