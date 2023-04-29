package array.find_the_index_of_the_first_occurrence_in_a_string_28;

public class Solution {
    public int strStr(String haystack, String needle) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < haystack.length(); ++i) {
            if (i < needle.length()) {
                sb.append(haystack.charAt(i));
            } else {
                if (sb.toString().equals(needle)) {
                    return i - needle.length();
                }
                sb.delete(0, 1);
                sb.append(haystack.charAt(i));
            }
        }
        if (sb.toString().equals(needle)) {
            return haystack.length() - needle.length();
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.strStr("sadbutsad", "sad"));
        System.out.println(s.strStr("leetcode", "leeto"));
        System.out.println(s.strStr("mississippi", "pi"));
    }
}
