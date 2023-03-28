package two_pointers.reverse_string_344;

public class Solution {
    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        while (l < r) {
            char tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;
            l += 1;
            r -= 1;
        }
    }

    public static void main(String[] args) {

    }
}
