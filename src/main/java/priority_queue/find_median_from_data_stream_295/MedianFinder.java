package priority_queue.find_median_from_data_stream_295;

import java.util.PriorityQueue;

public class MedianFinder {
    private PriorityQueue<Integer> pq1;
    private PriorityQueue<Integer> pq2;

    public MedianFinder() {
        this.pq1 = new PriorityQueue<>((a, b) -> b - a);
        this.pq2 = new PriorityQueue<>();
    }

    public void addNum(int num) {
        if (pq1.isEmpty()) {
            pq1.add(num);
        } else if (pq1.size() > pq2.size()) {
            int val1 = pq1.peek();
            if (num > val1) {
                pq2.add(num);
            } else {
                pq1.poll();
                pq2.add(val1);
                pq1.add(num);
            }
        } else {
            int val2 = pq2.peek();
            if (num < val2) {
                pq1.add(num);
            } else {
                pq2.poll();
                pq1.add(val2);
                pq2.add(num);
            }
        }
    }

    public double findMedian() {
        return (pq1.size() > pq2.size() ? pq1.peek() : (pq1.peek() + pq2.peek()) * 1.0 / 2);
    }
}
