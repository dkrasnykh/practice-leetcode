package two_pointers.valid_palindrome_II_680;

//https://www.youtube.com/watch?v=JrxRYBwG6EI
public class Solution2 {
    public boolean validPalindrome(String s) {
        int l = 0, r = s.length() - 1;
        while(l < r){
            if(s.charAt(l) != s.charAt(r)){
                StringBuilder skipL = new StringBuilder(s.substring(l+1, r+1)), skipR = new StringBuilder(s.substring(l, r));
                return skipL.toString().equals(skipL.reverse().toString())
                        || skipR.toString().equals(skipR.reverse().toString());
            }
            l += 1;
            r -= 1;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution2 s = new Solution2();

        System.out.println(s.validPalindrome("aba"));
        System.out.println(s.validPalindrome("abca"));
        System.out.println(s.validPalindrome("abc"));
        System.out.println(s.validPalindrome("abcbka"));
        System.out.println(s.validPalindrome("akbcba"));
        System.out.println(s.validPalindrome("ebcbbececabbacecbbcbe"));
        System.out.println(s.validPalindrome("ababbab"));
    }
}
