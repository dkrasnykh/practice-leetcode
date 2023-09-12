package array.minimum_deletions_to_make_character_frequencies_unique_1647.solution1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

//https://www.youtube.com/watch?v=h8AZEN49gTc
public class Solution {
    public int minDeletions(String s) {
        Map<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < s.length(); ++i) {
            count.compute(s.charAt(i), (k, v) -> v == null ? 1 : v + 1);
        }
        Set<Integer> used_freq = new HashSet<>();
        int result = 0;
        for(Map.Entry<Character, Integer> e : count.entrySet()){
            int freq = e.getValue();
            while(freq > 0 && used_freq.contains(freq)){
                freq -= 1;
                result += 1;
            }
            used_freq.add(freq);
        }
        return result;
    }
}
