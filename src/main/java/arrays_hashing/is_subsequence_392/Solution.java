package arrays_hashing.is_subsequence_392;

public class Solution {
    public boolean isSubsequence(String s, String t) {
        int p = 0;
        for (int i = 0; i < t.length(); ++i) {
            if (p < s.length() && s.charAt(p) == t.charAt(i)) {
                ++p;
            }
        }
        return p == s.length();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isSubsequence("abc", "ahbgdc"));
        System.out.println(s.isSubsequence("axc", "ahbgdc"));
    }
}
