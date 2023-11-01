package two_pointers.valid_palindrome_II_680;

public class Solution {
    public boolean validPalindrome1(String s) {
        int l = 0, r = s.length() - 1;
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l += 1;
                r -= 1;
            } else {
                return false;
            }
        }
        return true;
    }

    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        boolean deleted = false;
        while (l < r) {
            if (s.charAt(l) == s.charAt(r)) {
                l += 1;
                r -= 1;
            } else if (!deleted && l + 1 == r) {
                deleted = true;
                r -= 1;
            } else if (!deleted && s.charAt(l) == s.charAt(r - 1) && validPalindrome1(s.substring(0, r) + s.substring(r + 1))) {
                deleted = true;
                r -= 1;
            } else if (!deleted && s.charAt(l + 1) == s.charAt(r) && validPalindrome1(s.substring(0, l) + s.substring(l + 1))) {
                deleted = true;
                l += 1;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();

        System.out.println(s.validPalindrome("aba"));
        System.out.println(s.validPalindrome("abca"));
        System.out.println(s.validPalindrome("abc"));
        System.out.println(s.validPalindrome("abcbka"));
        System.out.println(s.validPalindrome("akbcba"));
        System.out.println(s.validPalindrome("ebcbbececabbacecbbcbe"));
        System.out.println(s.validPalindrome("ababbab"));
    }
}
