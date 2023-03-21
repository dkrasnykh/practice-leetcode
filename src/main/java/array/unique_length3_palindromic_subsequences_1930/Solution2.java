package array.unique_length3_palindromic_subsequences_1930;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://www.youtube.com/watch?v=3THUt0vAFLU
public class Solution2 {
    public int countPalindromicSubsequence(String s) {
        Set<char[]> res = new HashSet<>();
        Set<Character> left = new HashSet<>();
        Map<Character, Integer> right = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            right.compute(s.charAt(i), (key, value) -> (value == null) ? 1 : value + 1);
        }

        for(int i = 0; i<s.length(); ++i){
            right.compute(s.charAt(i), (key, value)-> value-1);
            if(right.get(s.charAt(i)) == 0){
                right.remove(s.charAt(i));
            }

            for(int j = 0; j<26; ++j){
                char c = (char)('a' + j);
                if(left.contains(c) && right.containsKey(c)){
                    res.add(new char[]{s.charAt(i), c});
                }
            }
            left.add(s.charAt(i));
        }

        return res.size();
    }


    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.println(s.countPalindromicSubsequence("aabca"));
        System.out.println(s.countPalindromicSubsequence("adc"));
        System.out.println(s.countPalindromicSubsequence("bbcbaba"));

    }
}
