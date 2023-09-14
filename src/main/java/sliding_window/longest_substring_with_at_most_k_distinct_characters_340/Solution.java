package sliding_window.longest_substring_with_at_most_k_distinct_characters_340;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        Map<Character, Integer> window = new HashMap<>();
        int l = 0;
        int currLen = 0, maxLen = 0;
        for (int r = 0; r < s.length(); ++r) {
            window.compute(s.charAt(r), (key, val) -> val == null ? 1 : val + 1);
            currLen += 1;
            while (window.size() > k) {
                window.compute(s.charAt(l), (key, val) -> val - 1);
                currLen -= 1;
                if (window.get(s.charAt(l)) == 0) {
                    window.remove(s.charAt(l));
                }
                l += 1;
            }
            maxLen = Math.max(maxLen, currLen);
        }
        return maxLen;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLongestSubstringKDistinct("eceba", 2));
        System.out.println(s.lengthOfLongestSubstringKDistinct("aa", 1));
    }
}
