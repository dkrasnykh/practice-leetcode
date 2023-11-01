package sliding_window.longest_substring_without_repeating_characters_3;

import java.util.ArrayDeque;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        ArrayDeque<Character> unique = new ArrayDeque<>();
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            if (unique.contains(s.charAt(i))) {
                res = Math.max(res, unique.size());
                char first;
                do {
                    first = unique.pollFirst();
                } while (first != s.charAt(i));
            }
            unique.addLast(s.charAt(i));
        }
        return Math.max(res, unique.size());
    }

    public static void main(String[] args) {

    }
}
