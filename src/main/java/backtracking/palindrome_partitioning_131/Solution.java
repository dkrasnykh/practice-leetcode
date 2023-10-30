package backtracking.palindrome_partitioning_131;

import java.util.ArrayList;
import java.util.List;

//https://www.youtube.com/watch?v=3jvWodd7ht0
public class Solution {
    public boolean isPali(String s, int l, int r) {
        while (l < r) {
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            }
            l += 1;
            r -= 1;
        }
        return true;
    }

    private void dfs(int ind, String s, List<String> part, List<List<String>> result) {
        if (ind >= s.length()) {
            result.add(new ArrayList<>(part));
            return;
        }
        for (int i = ind; i < s.length(); ++i) {
            if (isPali(s, ind, i)) {
                part.add(s.substring(ind, i + 1));
                dfs(i + 1, s, part, result);
                part.remove(part.size() - 1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        dfs(0, s, new ArrayList<>(), result);
        return result;
    }

    public static void main(String[] args) {

    }
}
