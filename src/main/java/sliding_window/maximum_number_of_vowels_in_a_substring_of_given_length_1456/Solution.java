package sliding_window.maximum_number_of_vowels_in_a_substring_of_given_length_1456;

import java.util.Set;
import java.util.HashSet;
import java.util.List;

public class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> vowels = new HashSet<>(List.of('a', 'e', 'i', 'o', 'u'));
        int l = 0;
        int max = 0;
        int curr = 0;
        for(int r = 0; r < s.length(); ++r){
            if (r >= k) {
                max = Math.max(max, curr);
                curr -= (vowels.contains(s.charAt(l)) ? 1 : 0);
                l += 1;
            }
            curr += (vowels.contains(s.charAt(r)) ? 1 : 0);
        }
        max = Math.max(max, curr);
        return max;
    }
}
