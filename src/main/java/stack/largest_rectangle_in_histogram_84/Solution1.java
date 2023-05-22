package stack.largest_rectangle_in_histogram_84;

import java.util.ArrayDeque;
import java.util.Arrays;

//https://www.youtube.com/watch?v=zx5Sw9130L0
public class Solution1 {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        for(int i = 0; i < heights.length; ++i){
            int start = i;
            while(!stack.isEmpty() && stack.getLast()[1]>heights[i]){
                int index = stack.getLast()[0];
                int height = stack.pollLast()[1];
                maxArea = Math.max(maxArea, height *(i-index));
                start = index;
            }
            stack.addLast(new int[]{start, heights[i]});
        }
        while(!stack.isEmpty()){
            int i = stack.getLast()[0];
            int h = stack.pollLast()[1];
            maxArea = Math.max(maxArea, h*(heights.length-i));
        }
        return maxArea;
    }

    public static void main(String[] args) {

    }
}
