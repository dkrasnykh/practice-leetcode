package two_pointers.one_edit_distance_161;

//не сдано на leetcode (premium)
public class Solution {
    public boolean equal(String s, int is, String t, int it) {
        if (s.length() - is != t.length() - it) {
            return false;
        }
        while (is < s.length()) {
            if (s.charAt(is) != t.charAt(it)) {
                return false;
            }
            is += 1;
            it += 1;
        }
        return true;
    }

    public boolean isOneEditDistance(String s, String t) {
        int is = 0, it = 0;
        while (is < s.length() && it < t.length()) {
            if (s.charAt(is) != t.charAt(it)) {
                return equal(s, is, t, it + 1) || equal(s, is + 1, t, it) ||
                        equal(s, is + 1, t, it + 1);
            }
            is += 1;
            it += 1;
        }
        return s.length() - is == 1 || t.length() - it == 1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isOneEditDistance("ab", "acb"));
        System.out.println(s.isOneEditDistance("", ""));
        System.out.println(s.isOneEditDistance("a", ""));
        System.out.println(s.isOneEditDistance("", "A"));
        System.out.println(s.isOneEditDistance("akcb", "acb"));
        System.out.println(s.isOneEditDistance("akkcb", "acb"));
        System.out.println(s.isOneEditDistance("akcb", "acb"));
        System.out.println(s.isOneEditDistance("acb", "acbk"));
    }
}
