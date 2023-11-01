package sliding_window.minimum_window_substring_76;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String minWindow(String s, String t) {
        if (t.length() > s.length()) return "";
        Map<Character, Integer> tCount = new HashMap<>();
        for (int i = 0; i < t.length(); ++i) {
            tCount.compute(t.charAt(i), (k, v) -> (v == null) ? 1 : v + 1);
        }
        int matches = 0;
        int r = 0;
        int first = 0, last = 0, window = s.length() + 1;
        for (int l = 0; l <= s.length() - t.length(); ++l) {
            while (r < s.length() && matches < t.length()) {
                if (tCount.containsKey(s.charAt(r))) {
                    if (tCount.get(s.charAt(r)) > 0) {
                        matches += 1;
                    }
                    tCount.compute(s.charAt(r), (k, v) -> v - 1);
                }
                r += 1;
            }
            if (matches == t.length() && window > r - l) {
                window = r - l;
                first = l;
                last = r;
            }
            if (tCount.containsKey(s.charAt(l))) {
                tCount.compute(s.charAt(l), (k, v) -> v + 1);
                if (tCount.get(s.charAt(l)) > 0) {
                    matches -= 1;
                }
            }
        }
        return s.substring(first, last);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.minWindow("ADOBECODEBANC", "ABC")); // BANC
        System.out.println(s.minWindow("a", "a"));
        System.out.println(s.minWindow("a", "aa"));
    }
}
