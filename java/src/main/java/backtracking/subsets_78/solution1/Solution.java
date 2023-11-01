package backtracking.subsets_78.solution1;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    private void dfs(int i, int[] nums, List<List<Integer>> subsets,
                     ArrayDeque<Integer> subset){
        if(i >= nums.length){
            subsets.add(new ArrayList<>(subset));
        } else {
            subset.addLast(nums[i]);
            dfs(i + 1, nums, subsets, subset);
            subset.pollLast();
            dfs(i + 1, nums, subsets, subset);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayDeque<Integer> subset = new ArrayDeque<>();
        dfs(0, nums, result, subset);
        return result;
    }
}
