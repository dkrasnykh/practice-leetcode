package arrays_hashing.ransom_note_383;

public class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] letters = new int[26];
        for (int i = 0; i < magazine.length(); ++i) {
            letters[magazine.charAt(i) - 'a'] += 1;
        }
        for (int i = 0; i < ransomNote.length(); ++i) {
            letters[ransomNote.charAt(i) - 'a'] -= 1;
            if (letters[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
