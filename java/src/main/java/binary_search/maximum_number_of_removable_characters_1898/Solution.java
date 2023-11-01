package binary_search.maximum_number_of_removable_characters_1898;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    private boolean isSubsequence(int m, String s, String t, int[] removable) {
        Set<Integer> removed = new HashSet<>();
        for (int i = 0; i <= m; ++i) {
            removed.add(removable[i]);
        }
        int p = 0;
        for (int i = 0; i < t.length(); ++i) {
            if (p < s.length() && s.charAt(p) == t.charAt(i) && !removed.contains(i)) {
                ++p;
            }
        }
        return p == s.length();
    }
    public int maximumRemovals(String s, String p, int[] removable) {
        int l = 0, r = removable.length - 1;
        while (l <= r) {
            int m = l + (r - l) / 2;
            if (!isSubsequence(m, p, s, removable)) {
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return l;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        // "abcacb", p = "ab", removable = [3,1,0]
        System.out.println(s.maximumRemovals("abcacb", "ab", new int[]{3, 1, 0}));
        System.out.println(s.maximumRemovals("abcbddddd", "abcd", new int[]{3, 2, 1, 4, 5, 6}));
        System.out.println(s.maximumRemovals("abcab", "abc", new int[]{0, 1, 2, 3, 4}));
    }
}
