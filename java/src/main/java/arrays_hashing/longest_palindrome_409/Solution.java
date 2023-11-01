package arrays_hashing.longest_palindrome_409;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            map.compute(s.charAt(i), (k, v) -> v == null ? 1 : v + 1);
        }
        int addition = 0, length = 0;
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            length += (e.getValue() - e.getValue() % 2);
            addition += e.getValue() % 2;
        }
        return length + (addition > 0 ? 1 : 0);
    }
}
