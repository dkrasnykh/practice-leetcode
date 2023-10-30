package backtracking.letter_combinations_of_a_phone_number_17.solution1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://www.youtube.com/watch?v=0snEunUacZY
public class Solution {
    private Map<Character, char[]> digitToChar = new HashMap<>();

    {
        digitToChar.put('2', new char[]{'a', 'b', 'c'});
        digitToChar.put('3', new char[]{'d', 'e', 'f'});
        digitToChar.put('4', new char[]{'g', 'h', 'i'});
        digitToChar.put('5', new char[]{'j', 'k', 'l'});
        digitToChar.put('6', new char[]{'m', 'n', 'o'});
        digitToChar.put('7', new char[]{'p', 'q', 'r', 's'});
        digitToChar.put('8', new char[]{'t', 'u', 'v'});
        digitToChar.put('9', new char[]{'w', 'x', 'y', 'z'});
    }

    private void dfs(int i, String digits, StringBuilder curStr, List<String> result) {
        if (curStr.length() == digits.length()) {
            result.add(curStr.toString());
            return;
        }
        for (char c : digitToChar.get(digits.charAt(i))) {
            curStr.append(c);
            dfs(i + 1, digits, curStr, result);
            curStr.delete(curStr.length() - 1, curStr.length());
        }
    }

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        dfs(0, digits, new StringBuilder(), result);
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> res = s.letterCombinations("23");
        for (String e : res) {
            System.out.print(e + " ");
        }
    }
}
