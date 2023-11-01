package two_pointers.reverse_words_in_a_string_151;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class Solution {
    public String reverseWords(String s) {
        int length = 0;
        s = s.concat(" ");
        List<String> words = new ArrayList<>();
        for(int i = 0; i < s.length(); ++i){
            if (s.charAt(i) == ' ' && length != 0) {
                words.add(s.substring(i - length, i));
                length = 0;
            } else if (s.charAt(i) != ' ') {
                length += 1;
            }
        }
        Collections.reverse(words);
        return words.stream().collect(Collectors.joining(" "));
    }
}
