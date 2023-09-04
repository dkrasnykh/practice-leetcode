package stack.car_fleet_853;

import java.util.*;

public class Solution1 {
    public int carFleet(int target, int[] position, int[] speed) {
        TreeSet<int[]> cars = new TreeSet<>((c1,c2)->c1[0]==c2[0]?c1[1]-c2[1]:c1[0]-c2[0]);
        for(int i = 0; i < position.length; ++i){
            cars.add(new int[]{position[i], speed[i]});
        }
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        for(int[] c : cars){
            Double time1 = stack.isEmpty() ? 0.0 : (double)(target - stack.getLast()[0])/stack.getLast()[1];
            Double time2 = (double)(target - c[0])/c[1];
            while(!stack.isEmpty() && time1.compareTo(time2) <= 0){
                stack.pollLast();
                time1 = stack.isEmpty() ? 0.0 : (double)(target - stack.getLast()[0])/stack.getLast()[1];
            }
            stack.addLast(new int[]{c[0], c[1]});
        }
        return stack.size();
    }
}
