package arrays_hashing.valid_anagram_242;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> smap = new HashMap<>();
        Map<Character, Integer> tmap = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            smap.compute(s.charAt(i), (key, value) -> value == null ? 1 : value + 1);
        }
        for(int i = 0; i<t.length(); ++i){
            tmap.compute(t.charAt(i), (key, value) -> value == null ? 1 : value + 1);
        }
        return smap.equals(tmap);
    }

    public static void main(String[] args) {
        // s = "anagram", t = "nagaram"
        Solution s = new Solution();
        System.out.println(s.isAnagram("anagram", "nagaram"));
        System.out.println(s.isAnagram("rat", "car"));
    }
}
