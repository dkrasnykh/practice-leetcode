package array.unique_length3_palindromic_subsequences_1930;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Solution {
    public int countPalindromicSubsequence(String s) {
        Map<Character, Integer> first = new HashMap<>();
        Map<Character, Integer> last = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            if (!first.containsKey(s.charAt(i))) {
                first.put(s.charAt(i), i);
            }
            last.put(s.charAt(i), i);
        }
        int total = 0;
        for (Character c : first.keySet()) {
            if (first.get(c) != last.get(c)) {
                Set<Character> tmp = new HashSet<>();
                for (int i = first.get(c) + 1; i < last.get(c); ++i) {
                    tmp.add(s.charAt(i));
                }
                total += tmp.size();
            }
        }
        return total;
    }

    public static void main(String[] args) {
        /*
        Input: s = "aabca"
        Output: 3
        Explanation: The 3 palindromic subsequences of length 3 are:
        - "aba" (subsequence of "aabca")
        - "aaa" (subsequence of "aabca")
        - "aca" (subsequence of "aabca")
        */
        Solution s = new Solution();
        System.out.println(s.countPalindromicSubsequence("aabca"));
        System.out.println(s.countPalindromicSubsequence("adc"));
        System.out.println(s.countPalindromicSubsequence("bbcbaba"));
    }
}
