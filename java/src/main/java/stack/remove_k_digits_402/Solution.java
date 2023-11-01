package stack.remove_k_digits_402;

import java.util.ArrayDeque;

public class Solution {
    public String removeKdigits(String num, int k) {
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < num.length(); ++i) {
            int n = Integer.parseInt(String.valueOf(num.charAt(i)));
            while (!stack.isEmpty() && stack.getLast() > n && k > 0) {
                stack.pollLast();
                k -= 1;
            }
            stack.addLast(n);
        }
        for (int i = 0; i < k; ++i) {
            stack.pollLast();
        }
        StringBuilder answer = new StringBuilder();
        while (!stack.isEmpty()) {
            if (answer.length() == 0 && stack.getFirst() == 0) {
                stack.pollFirst();
            } else {
                answer.append(stack.pollFirst());
            }
        }
        return answer.length() == 0 ? "0" : answer.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.removeKdigits("1432219", 3));
        System.out.println(s.removeKdigits("10200", 1));
        System.out.println(s.removeKdigits("10", 2));
        System.out.println(s.removeKdigits("11", 2));
        System.out.println(s.removeKdigits("12345", 2));
        System.out.println(s.removeKdigits("10", 1));
    }
}
