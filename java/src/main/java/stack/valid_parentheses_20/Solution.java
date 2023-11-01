package stack.valid_parentheses_20;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isValid(String s) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        Map<Character, Character> closeToOpen = new HashMap<>();
        closeToOpen.put(')', '(');
        closeToOpen.put(']', '[');
        closeToOpen.put('}', '{');
        for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (closeToOpen.containsValue(c)) {
                stack.addLast(c);
            } else if (stack.isEmpty() || stack.getLast() != closeToOpen.get(c)) {
                return false;
            } else {
                stack.pollLast();
            }
        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isValid("()[]{}"));
    }
}
