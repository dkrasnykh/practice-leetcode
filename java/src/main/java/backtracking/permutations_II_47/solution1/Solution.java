package backtracking.permutations_II_47.solution1;

import java.util.*;

public class Solution {

    private void dfs(List<List<Integer>> result, ArrayDeque<Integer> p, Map<Integer, Integer> count, int size) {
        if (p.size() == size) {
            result.add(new ArrayList<>(p));
            return;
        }
        for (Integer n : count.keySet()) {
            if (count.get(n) > 0) {
                p.addLast(n);
                count.compute(n, (k, v) -> v - 1);
                dfs(result, p, count, size);
                count.compute(n, (k,v) -> v + 1);
                p.pollLast();
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, Integer> count = new HashMap<>();
        for (Integer n : nums) {
            count.compute(n, (k, v) -> v == null ? 1 : v + 1);
        }
        dfs(result, new ArrayDeque<>(), count, nums.length);
        return result;
    }
}
