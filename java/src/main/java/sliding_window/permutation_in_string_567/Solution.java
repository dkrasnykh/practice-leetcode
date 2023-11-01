package sliding_window.permutation_in_string_567;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int k = s1.length();
        Map<Character, Integer> m1 = new HashMap<>();
        Map<Character, Integer> m2 = new HashMap<>();
        for (int i = 0; i < s1.length(); ++i) {
            m1.compute(s1.charAt(i), (key, value) -> value == null ? 1 : value + 1);
        }
        for (int i = 0; i < s2.length(); ++i) {
            m2.compute(s2.charAt(i), (key, value) -> value == null ? 1 : value + 1);
            if (i >= k - 1) {
                if (m1.equals(m2)) {
                    return true;
                }
                if (m2.get(s2.charAt(i - k + 1)) == 1) {
                    m2.remove(s2.charAt(i - k + 1));
                } else {
                    m2.compute(s2.charAt(i - k + 1), (key, value) -> value - 1);
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        /*
        Input: s1 = "ab", s2 = "eidbaooo"
        Output: true
        Explanation: s2 contains one permutation of s1 ("ba").
        */
        Solution s = new Solution();
        System.out.println(s.checkInclusion("ab", "eidbaooo"));
    }
}
