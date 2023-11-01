package backtracking.subsets_II_90;

import java.util.*;

public class Solution {

    private void backtrack(int i, List<List<Integer>> subsets, ArrayDeque<Integer> subset, int[] nums) {
        if (i == nums.length) {
            subsets.add(new ArrayList<>(subset));
        } else {
            subset.addLast(nums[i]);
            backtrack(i + 1, subsets, subset, nums);
            subset.pollLast();
            while(i + 1 < nums.length && nums[i] == nums[i + 1]){
                i += 1;
            }
            backtrack(i + 1, subsets, subset, nums);
        }
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        backtrack(0, result, new ArrayDeque<>(), nums);
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        //[[],[1],[1,2],[1,2,2],[2],[2,2]]
        List<List<Integer>> result = s.subsetsWithDup(new int[]{1, 2, 2});
        for (List<Integer> e : result) {
            System.out.println(e);
        }
    }
}
