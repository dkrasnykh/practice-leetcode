package priority_queue.task_scheduler_621.solution1;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

//https://www.youtube.com/watch?v=s8p8ukTyA2I
public class Solution {
    public int leastInterval(char[] tasks, int n) {
        if (n == 0) return tasks.length;
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        Queue<int[]> q = new LinkedList<>();
        int[] cnt = new int[26];
        for (char c : tasks) cnt[c - 'A'] += 1;
        for (int val : cnt) if (val > 0) pq.add(val);
        int time = 0;

        while (!pq.isEmpty() || !q.isEmpty()) {
            time += 1;
            if (!pq.isEmpty()) {
                int val = pq.poll();
                val -= 1;
                if (val > 0) q.add(new int[]{val, time + n});
            }
            if(!q.isEmpty() && q.peek()[1] == time){
                pq.add(q.poll()[0]);
            }
        }
        return time;
    }
}
