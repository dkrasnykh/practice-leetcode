package arrays_hashing.first_unique_character_in_a_string_387;

public class Solution {
    public int firstUniqChar(String s) {
        int[] letters = new int[26];
        for (int i = 0; i < s.length(); ++i) {
            letters[s.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < s.length(); ++i) {
            if (letters[s.charAt(i) - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
}
