package two_pointers.assign_cookies_455;

import java.util.Arrays;

public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        int result = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j]) {
                result += 1;
                i += 1;
                j += 1;
            } else {
                j += 1;
            }
        }
        return result;
    }
}
