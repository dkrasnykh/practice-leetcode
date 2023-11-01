package priority_queue.task_scheduler_621;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] cnt = new int[26];
        for (int i = 0; i < tasks.length; ++i) {
            cnt[tasks[i] - 'A'] += 1;
        }
        PriorityQueue<Integer> q = new PriorityQueue<>((a, b) -> b - a);
        for (int i = 0; i < 26; ++i) {
            if (cnt[i] > 0) {
                q.add(cnt[i]);
            }
        }
        int result = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> tmp = new ArrayList<>();
            if (size >= n + 1) {
                result += (n + 1);
                size = n + 1;
            } else {
                result += (q.peek() > 1) ? n + 1 : size;
            }
            for (int i = 0; i < size; ++i) {
                int first = q.poll();
                first -= 1;
                if (first > 0) {
                    tmp.add(first);
                }
            }
            q.addAll(tmp);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.leastInterval(new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'}, 2));
    }
}
