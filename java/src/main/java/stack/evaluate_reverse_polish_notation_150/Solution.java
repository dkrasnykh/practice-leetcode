package stack.evaluate_reverse_polish_notation_150;

import java.util.ArrayDeque;

public class Solution {
    public int evalRPN(String[] tokens) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        int a, b;
        for(String token : tokens){
            switch (token){
                case "+":
                    stack.addLast(stack.pollLast() + stack.pollLast());
                    break;
                case "-":
                    a = stack.pollLast();
                    b = stack.pollLast();
                    stack.addLast(b - a);
                    break;
                case "*":
                    stack.addLast(stack.pollLast() * stack.pollLast());
                    break;
                case "/":
                    a = stack.pollLast();
                    b = stack.pollLast();
                    stack.addLast(b / a);
                    break;
                default:
                    stack.addLast(Integer.parseInt(token));
            }
        }
        return stack.getLast();
    }
}
