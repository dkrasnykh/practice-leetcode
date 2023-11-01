package hash_table.LongestSubstringWithoutRepeatingCharacters;

import java.util.ArrayDeque;

class Solution {
    //https://leetcode.com/problems/longest-substring-without-repeating-characters/
    public int lengthOfLongestSubstring(String s) {
        ArrayDeque<Character> buffer = new ArrayDeque<>();
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if(buffer.contains(s.charAt(i))){
                if(max< buffer.size()){
                    max = buffer.size();
                }
                char c=(char)(s.charAt(i)+1);
                while(c!=s.charAt(i)){
                    c=buffer.removeFirst();
                }
                buffer.addLast(s.charAt(i));
            } else {
                buffer.addLast(s.charAt(i));
            }
        }
        return Math.max(max, buffer.size());
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring("anbvcxzeyukll"));
    }
}
