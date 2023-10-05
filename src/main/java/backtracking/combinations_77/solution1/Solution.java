package backtracking.combinations_77.solution1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    private void backtrack(List<List<Integer>> res, ArrayDeque<Integer> comb, int start, int n, int k) {
        if (comb.size() == k) {
            res.add(new ArrayList<>(comb));
            return;
        }
        for (int i = start; i <= n; ++i) {
            comb.addLast(i);
            backtrack(res, comb, i + 1, n, k);
            comb.pollLast();
        }
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(result, new ArrayDeque<>(), 1, n, k);
        return result;
    }
}
