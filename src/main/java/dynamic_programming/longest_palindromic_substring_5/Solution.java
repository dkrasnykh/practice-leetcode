package dynamic_programming.longest_palindromic_substring_5;

public class Solution {
    public String longestPalindrome(String s) {
        int maxSub = 1;
        String result = s.substring(0, 1);
        for (int i = 1; i < s.length() - 1; ++i) {
            int local = 1;
            int l = i - 1, r = i + 1;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                local += 2;
                l -= 1;
                r += 1;
            }
            if (maxSub < local) {
                maxSub = local;
                result = s.substring(l + 1, r);
            }
        }
        for (int i = 1; i < s.length(); ++i) {
            int l = i - 1, r = i;
            int local = 0;
            while (l >= 0 && r < s.length() && s.charAt(l) == s.charAt(r)) {
                local += 2;
                l -= 1;
                r += 1;
            }
            if (maxSub < local) {
                maxSub = local;
                result = s.substring(l + 1, r);
            }
        }
        return result;
    }
}
