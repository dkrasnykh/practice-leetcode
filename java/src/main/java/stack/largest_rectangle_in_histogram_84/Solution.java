package stack.largest_rectangle_in_histogram_84;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Solution {
    public int largestRectangleArea(int[] heights) {
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        int[] rightMin = new int[heights.length];
        Arrays.fill(rightMin, heights.length);
        int[] leftMin = new int[heights.length];
        Arrays.fill(leftMin, -1);
        for (int i = 0; i < heights.length; ++i) {
            while (!stack.isEmpty() && stack.getLast()[0] > heights[i]) {
                int[] e = stack.pollLast();
                rightMin[e[1]] = i;
            }
            stack.addLast(new int[]{heights[i], i});
        }
        stack.clear();
        for (int i = heights.length - 1; i >= 0; --i) {
            while (!stack.isEmpty() && stack.getLast()[0] > heights[i]) {
                int[] e = stack.pollLast();
                leftMin[e[1]] = i;
            }
            stack.addLast(new int[]{heights[i], i});
        }
        int maxArea = 0;
        for (int i = 0; i < heights.length; ++i) {
            maxArea = Math.max(maxArea, heights[i] * (rightMin[i] - leftMin[i] - 1));
        }
        return maxArea;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3}));
    }
}
