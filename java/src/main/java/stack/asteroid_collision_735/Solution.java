package stack.asteroid_collision_735;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (Integer asteroid : asteroids) {
            while (asteroid < 0 && !stack.isEmpty() && stack.getLast()>0 && Math.abs(asteroid) > stack.getLast()){
                stack.pollLast();
            }
            if(asteroid < 0 && !stack.isEmpty() && stack.getLast() > 0 && Math.abs(asteroid) == stack.getLast()){
                stack.pollLast();
            } else if (!(asteroid < 0 && !stack.isEmpty() && stack.getLast() > 0 && stack.getLast() > Math.abs(asteroid))){
                stack.addLast(asteroid);
            }
        }
        int[] ans = new int[stack.size()];
        int i = 0;
        while (!stack.isEmpty()) {
            ans[i++] = stack.pollFirst();
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(Arrays.toString(s.asteroidCollision(new int[]{5, 10, -5})));
        System.out.println(Arrays.toString(s.asteroidCollision(new int[]{8,-8})));
        //-2,-1,1,2
        System.out.println(Arrays.toString(s.asteroidCollision(new int[]{-2,-1,1,2})));
    }
}
