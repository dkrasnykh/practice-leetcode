package backtracking.combination_sum_II_40;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {

    private void backtrack(int i, int[] candidates, int target, List<List<Integer>> result, ArrayDeque<Integer> comb) {
        if (target == 0) {
            result.add(new ArrayList<>(comb));
        }
        if (i >= candidates.length || target <= 0) {
            return;
        }
        comb.addLast(candidates[i]);
        backtrack(i + 1, candidates, target - candidates[i], result, comb);
        comb.pollLast();
        while (i + 1 < candidates.length && candidates[i] == candidates[i + 1]) {
            i += 1;
        }
        backtrack(i + 1, candidates, target, result, comb);
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, candidates, target, result, new ArrayDeque<>());
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> result = s.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        for (List<Integer> e : result) {
            System.out.println(e);
        }
    }
}
