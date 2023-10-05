package backtracking.combination_sum_39;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Solution {
    private void generate(int i, int[] candidates, int target, ArrayDeque<Integer> combination, List<List<Integer>> result) {
        int sum = 0;
        Iterator<Integer> iterator = combination.iterator();
        while (iterator.hasNext()) {
            sum += candidates[iterator.next()];
        }
        if (sum == target) {
            List<Integer> res = new ArrayList<>();
            iterator = combination.iterator();
            while(iterator.hasNext()){
                res.add(candidates[iterator.next()]);
            }
            result.add(res);
        } else if (sum < target){
            for (int j = 0; j < candidates.length; ++j) {
                if (!combination.isEmpty() && combination.getLast() > j) {
                    continue;
                }
                combination.addLast(j);
                generate(i + 1, candidates, target, combination, result);
                combination.pollLast();
            }
        }
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ArrayDeque<Integer> combination = new ArrayDeque<>();
        List<List<Integer>> combinations = new ArrayList<>();
        generate(0, candidates, target, combination, combinations);
        return combinations;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> combinations = s.combinationSum(new int[]{2, 3, 6, 7}, 7);
        for (List<Integer> combination : combinations) {
            System.out.println(combination);
        }
    }
}
