package stack.remove_all_adjacent_duplicates_in_string_II_1209;

import java.util.ArrayDeque;

public class Solution {
    public String removeDuplicates(String s, int k) {
        ArrayDeque<Integer> stack1 = new ArrayDeque<>();
        ArrayDeque<Character> stack2 = new ArrayDeque<>();
        int lenght = 0;
        int i = 0;
        for (i = 0; i <= s.length(); ++i) {
            if (i != 0 && i < s.length() && s.charAt(i) != s.charAt(i - 1) || i == s.length()) {
                char c = s.charAt(i - 1);
                if (!stack2.isEmpty() && stack2.getLast() == c) {
                    lenght += stack1.pollLast();
                    stack2.pollLast();
                }
                int div = lenght / k;
                if (lenght - k * div > 0) {
                    stack1.addLast(lenght - k * div);
                    stack2.addLast(c);
                }
                lenght = 1;
            } else {
                lenght += 1;
            }
        }
        StringBuilder answer = new StringBuilder();
        while (!stack1.isEmpty()) {
            int n = stack1.pollFirst();
            char c = stack2.pollFirst();
            for(int j = 0; j < n; ++j){
                answer.append(c);
            }
        }
        return answer.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.removeDuplicates("abcd", 2));
        System.out.println(s.removeDuplicates("deeedbbcccbdaa", 3));
        System.out.println(s.removeDuplicates("pbbcggttciiippooaais", 2));
    }
}
