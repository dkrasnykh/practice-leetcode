package backtracking.combination_sum_II_40.solution1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//https://www.youtube.com/watch?v=rSA3t6BDDwg
public class Solution {
    private void backtrack(int pos, int[] candidates, int target, List<List<Integer>> result, ArrayDeque<Integer> comb) {
        if (target == 0) {
            result.add(new ArrayList<>(comb));
        }
        if (target <= 0) {
            return;
        }
        int prev = -1;
        for(int i = pos; i < candidates.length; ++i){
            if(candidates[i] == prev){
                continue;
            }
            comb.addLast(candidates[i]);
            backtrack(i + 1, candidates, target - candidates[i], result, comb);
            comb.pollLast();
            prev = candidates[i];
        }
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, candidates, target, result, new ArrayDeque<>());
        return result;
    }
}
