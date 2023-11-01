package priority_queue.last_stone_weight_1046;

import java.util.PriorityQueue;

public class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> q = new PriorityQueue<>((e1, e2) -> e2 - e1);
        for (Integer stone : stones) {
            q.add(stone);
        }
        while (q.size() > 1) {
            int y = q.poll();
            int x = q.poll();
            if (x < y) {
                q.add(y - x);
            }
        }
        return q.size() == 0 ? 0 : q.poll();
    }
}
