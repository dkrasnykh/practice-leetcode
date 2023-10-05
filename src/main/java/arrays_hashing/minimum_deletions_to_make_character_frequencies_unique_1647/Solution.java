package arrays_hashing.minimum_deletions_to_make_character_frequencies_unique_1647;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int minDeletions(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            map.compute(s.charAt(i), (k, v) -> v == null ? 1 : v + 1);
        }
        Integer[] freq = new Integer[map.size()];
        int i = 0;
        for (Map.Entry<Character, Integer> e : map.entrySet()) {
            freq[i] = e.getValue();
            i += 1;
        }
        Arrays.sort(freq, (e1, e2) -> e2 - e1);
        int result = 0;
        for (i = 1; i < freq.length; ++i) {
            if (freq[i] >= freq[i - 1] && freq[i - 1] != 0) {
                int inc = freq[i] - (freq[i - 1] - 1);
                freq[i] -= inc;
                result += inc;
            } else if (freq[i] > freq[i - 1] && freq[i - 1] == 0) {
                result += freq[i];
                freq[i] = 0;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.minDeletions("aab");
    }
}
