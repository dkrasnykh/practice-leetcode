package stack.asteroid_collision_735;

import java.util.ArrayDeque;

//https://www.youtube.com/watch?v=LN7KjRszjk4
public class Solution1 {
    public int[] asteroidCollision(int[] asteroids) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (Integer a : asteroids) {
            while (!stack.isEmpty() && a < 0 && stack.getLast()>0){
                int diff = a + stack.getLast();
                if(diff < 0){
                    stack.pollLast();
                } else if (diff > 0){
                    a = 0;
                } else {
                    a = 0;
                    stack.pollLast();
                }
            }
            if (a > 0){
                stack.addLast(a);
            }
        }
        int[] ans = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            ans[i++] = stack.pollFirst();
        }
        return ans;
    }

}
