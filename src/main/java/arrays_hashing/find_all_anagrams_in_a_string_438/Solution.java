package arrays_hashing.find_all_anagrams_in_a_string_438;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() < p.length()) {
            return ans;
        }
        int n = p.length();
        Map<Character, Integer> pmap = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < p.length(); ++i) {
            pmap.compute(p.charAt(i), (key, value) -> (value == null) ? 1 : value + 1);
            window.compute(s.charAt(i), (key, value) -> (value == null) ? 1 : value + 1);
        }
        if (pmap.equals(window)) {
            ans.add(0);
        }
        for (int i = n; i < s.length(); ++i) {
            window.compute(s.charAt(i - n), (key, value) -> value - 1);
            if (window.get(s.charAt(i - n)) == 0) {
                window.remove(s.charAt(i - n));
            }
            window.compute(s.charAt(i), (key, value) -> (value == null) ? 1 : value + 1);
            if (pmap.equals(window)) {
                ans.add(i - n + 1);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.findAnagrams("cbaebabacd", "abc"));
        System.out.println(s.findAnagrams("abab", "ab"));
    }
}
