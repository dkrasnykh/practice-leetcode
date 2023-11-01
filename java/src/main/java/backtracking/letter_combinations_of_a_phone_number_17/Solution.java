package backtracking.letter_combinations_of_a_phone_number_17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    private Map<Character, char[]> letters = new HashMap<>();
    {
        letters.put('2', new char[]{'a', 'b', 'c'});
        letters.put('3', new char[]{'d', 'e', 'f'});
        letters.put('4', new char[]{'g', 'h', 'i'});
        letters.put('5', new char[]{'j', 'k', 'l'});
        letters.put('6', new char[]{'m', 'n', 'o'});
        letters.put('7', new char[]{'p', 'q', 'r', 's'});
        letters.put('8', new char[]{'t', 'u', 'v'});
        letters.put('9', new char[]{'w', 'x', 'y', 'z'});
    }

    private void dfs(int ind, String digits, StringBuilder sb, List<String> result) {
        if (sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }
        for (int i = ind; i < digits.length(); ++i) {
            for (int j = 0; j < letters.get(digits.charAt(i)).length; ++j) {
                if (i != sb.length()) {
                    continue;
                }
                sb.append(letters.get(digits.charAt(i))[j]);
                dfs(ind + 1, digits, sb, result);
                sb.delete(sb.length() - 1, sb.length());
            }
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;
        dfs(0, digits, new StringBuilder(), result);
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> comb = s.letterCombinations("234");
        for (String c : comb) {
            System.out.print(c + " ");
        }
    }
}
