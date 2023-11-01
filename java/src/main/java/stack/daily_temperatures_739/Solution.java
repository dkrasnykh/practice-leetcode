package stack.daily_temperatures_739;

import java.util.ArrayDeque;

public class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        int[] answer = new int[temperatures.length];
        for(int i = 0; i < temperatures.length; ++i){
            while(!stack.isEmpty() && stack.getLast()[0] < temperatures[i]){
                int[] e = stack.pollLast();
                answer[e[1]] = i - e[1];
            }
            stack.addLast(new int[]{temperatures[i], i});
        }
        return answer;
    }


}
