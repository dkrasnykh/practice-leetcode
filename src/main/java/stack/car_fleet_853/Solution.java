package stack.car_fleet_853;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        List<int[]> sorted = new ArrayList<>();
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < position.length; ++i) {
            sorted.add(new int[]{i, position[i]});
        }
        sorted.sort(Comparator.comparingInt(a -> a[1]));
        for (int[] e : sorted) {
            while (!stack.isEmpty() && speed[stack.getLast()] > speed[e[0]]) {
                int ind = stack.getLast();
                double time1 = (target - position[ind]) * 1.0 / speed[ind];
                double time2 = (target - position[e[0]]) * 1.0 / speed[e[0]];
                if (Double.compare(time1, time2) <= 0) {
                    stack.pollLast();
                } else {
                    break;
                }
            }
            stack.addLast(e[0]);
        }
        return stack.size();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.carFleet(12, new int[]{10, 8, 0, 5, 3}, new int[]{2, 4, 1, 1, 3}));
        System.out.println(s.carFleet(10, new int[]{6, 8}, new int[]{3, 2}));
    }
}
