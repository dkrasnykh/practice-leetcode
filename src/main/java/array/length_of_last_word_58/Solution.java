package array.length_of_last_word_58;

public class Solution {
    public int lengthOfLastWord(String s) {
        int length = 0;
        for (int i = s.length() - 1; i >= 0; --i) {
            if (s.charAt(i) == ' ' && length > 0) {
                break;
            } else if (s.charAt(i) != ' ') {
                ++length;
            }
        }
        return length;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.lengthOfLastWord("Hello World"));
        System.out.println(s.lengthOfLastWord("   fly me   to   the moon  "));
        System.out.println(s.lengthOfLastWord("luffy is still joyboy"));
        System.out.println(s.lengthOfLastWord("joyboy"));
        System.out.println(s.lengthOfLastWord("                   "));
    }
}
