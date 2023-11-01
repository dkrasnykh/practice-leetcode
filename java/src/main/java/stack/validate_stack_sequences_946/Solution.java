package stack.validate_stack_sequences_946;

import java.util.ArrayDeque;

public class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int j = 0;
        for(int i = 0; i < pushed.length; ++i){
            stack.addLast(pushed[i]);
            while(j < popped.length && !stack.isEmpty() && stack.getLast() == popped[j]){
                stack.pollLast();
                j += 1;
            }
        }
        return stack.isEmpty();
    }
}
