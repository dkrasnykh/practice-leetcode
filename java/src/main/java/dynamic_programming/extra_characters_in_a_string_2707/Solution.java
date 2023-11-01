package dynamic_programming.extra_characters_in_a_string_2707;

import java.util.*;

public class Solution {
    public int dfs(int i, Map<Integer, Integer> dp, String s, Set<String> words){
        if(dp.containsKey(i)){
            return dp.get(i);
        }
        int res = 1 + dfs(i + 1, dp, s, words);
        for(int j = i; j < s.length(); ++j){
            if(words.contains(s.substring(i, j+1))){
                res = Math.min(res, dfs(j + 1, dp, s, words));
            }
        }
        dp.put(i, res);
        return res;
    }

    public int minExtraChar(String s, String[] dictionary) {
        Set<String> words = new HashSet<>(List.of(dictionary));
        Map<Integer, Integer> dp = new HashMap<>();
        dp.put(s.length(), 0);
        return dfs(0, dp, s, words);
    }
}
