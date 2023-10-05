package arrays_hashing.word_pattern_290;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public boolean wordPattern(String pattern, String s) {
        String[] word = s.split(" ");
        if (pattern.length() != word.length) {
            return false;
        }
        Map<Character, String> pattern_s = new HashMap<>();
        Map<String, Character> s_pattern = new HashMap<>();
        for(int i = 0; i<pattern.length(); ++i){
            if(pattern_s.containsKey(pattern.charAt(i)) && !s_pattern.containsKey(word[i])
                    || !pattern_s.containsKey(pattern.charAt(i)) && s_pattern.containsKey(word[i])
                    || pattern_s.containsKey(pattern.charAt(i)) && s_pattern.containsKey(word[i])
                    && (!pattern_s.get(pattern.charAt(i)).equals(word[i]) || s_pattern.get(word[i])!=pattern.charAt(i))){
                return false;
            }
            pattern_s.put(pattern.charAt(i), word[i]);
            s_pattern.put(word[i], pattern.charAt(i));
        }
        return true;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.wordPattern("abba","dog cat cat dog"));
        //pattern = "abba", s = "dog cat cat fish"
        System.out.println(s.wordPattern("abba","dog cat cat fish"));
        //pattern = "aaaa", s = "dog cat cat dog"
        System.out.println(s.wordPattern("aaaa","dog cat cat dog"));
    }
}
