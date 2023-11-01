package priority_queue.kth_largest_element_in_a_stream_703;

import java.util.PriorityQueue;

public class KthLargest {
    private PriorityQueue<Integer> q;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.q = new PriorityQueue<>();
        this.k = k;

        for (int i = 0; i < nums.length; ++i) {
            this.q.add(nums[i]);
            if (i >= this.k) {
                q.poll();
            }
        }
    }

    public int add(int val) {
        q.add(val);
        if (q.size() > k) {
            q.poll();
        }
        return q.peek();
    }

    public static void main(String[] args) {
        PriorityQueue<Integer> q1 = new PriorityQueue<>((e1, e2) -> e2 - e1);
        PriorityQueue<Integer> q2 = new PriorityQueue<>();
        q1.add(4);
        q2.add(4);
        q1.add(5);
        q2.add(5);
        q1.add(8);
        q2.add(8);
        q1.add(2);
        q2.add(2);

        q1.add(5);
        q2.add(5);

        q1.remove(5);
        int test = 2;
    }
}
