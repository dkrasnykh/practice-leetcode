package arrays_hashing.bulls_and_cows_299;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public String getHint(String secret, String guess) {
        Map<Character, Integer> map = new HashMap<>();
        int bulls = 0, cows = 0;
        for (int i = 0; i < secret.length(); ++i) {
            if (i < guess.length() && secret.charAt(i) == guess.charAt(i)) {
                bulls += 1;
            } else {
                map.compute(secret.charAt(i), (k, v) -> v == null ? 1 : v + 1);
            }
        }
        for (int i = 0; i < guess.length(); ++i) {
            if ((i >= secret.length() || secret.charAt(i) != guess.charAt(i)) && map.getOrDefault(guess.charAt(i), 0) > 0) {
                cows += 1;
                map.compute(guess.charAt(i), (k, v) -> v - 1);
            }
        }
        return Integer.toString(bulls).concat("A").concat(Integer.toString(cows)).concat("B");
    }
}
