package sliding_window.maximum_number_of_vowels_in_a_substring_of_given_length_1456.solution1;

import java.util.Set;
import java.util.HashSet;
import java.util.List;

//https://www.youtube.com/watch?v=kEfPSzgL-Ss
public class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> vowelsSet = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));
        int l = 0, cnt = 0, result = 0;
        for(int r = 0; r < s.length(); ++r){
            cnt += (vowelsSet.contains(s.charAt(r)) ? 1 : 0);
            if(r - l + 1 > k){
                cnt -= (vowelsSet.contains(s.charAt(l)) ? 1 : 0);
                l += 1;
            }
            result = Math.max(result, cnt);
        }
        return result;
    }
}
