package stack.pattern132_456;

import java.util.ArrayDeque;

public class Solution {
    public boolean find132pattern(int[] nums) {
        ArrayDeque<int[]> stack = new ArrayDeque<>();
        int curMin = nums[0];
        for(int i = 1; i < nums.length; ++i){
            while(!stack.isEmpty() && nums[i] >= stack.getLast()[0]){
                stack.pollLast();
            }
            //nums[i] < stack.getLast()[0]
            if(!stack.isEmpty() && nums[i] > stack.getLast()[1]){
                return true;
            }
            stack.addLast(new int[]{nums[i], curMin});
            curMin = Math.min(curMin, nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.find132pattern(new int[]{1,2,3,4}));
        System.out.println(s.find132pattern(new int[]{3,1,4,2}));
        System.out.println(s.find132pattern(new int[]{-1,3,2,0}));
    }
}
