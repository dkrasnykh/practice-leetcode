package two_pointers.valid_palindrome_125;

public class Solution {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while (l < r) {
            if (!Character.isLetterOrDigit(s.charAt(l))) {
                l += 1;
            } else if (!Character.isLetterOrDigit(s.charAt(r))) {
                r -= 1;
            } else if (Character.toLowerCase(s.charAt(l)) == Character.toLowerCase(s.charAt(r))) {
                l += 1;
                r -= 1;
            } else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Solution s = new Solution();
        System.out.println(s.isPalindrome("A man, a plan, a canal: Panama"));
    }
}
