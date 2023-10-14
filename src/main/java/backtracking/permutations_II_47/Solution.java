package backtracking.permutations_II_47;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    private void generate(List<List<Integer>> result, ArrayDeque<Integer> p, boolean[] used, int[] nums) {
        if (p.size() == nums.length) {
            result.add(new ArrayList<>(p));
            return;
        }
        int prev = -11;
        for (int i = 0; i < nums.length; ++i) {
            if (used[i] || nums[i] == prev) {
                continue;
            }
            p.addLast(nums[i]);
            used[i] = true;
            generate(result, p, used, nums);
            p.pollLast();
            used[i] = false;
            prev = nums[i];
        }
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        generate(result, new ArrayDeque<>(), used, nums);
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        //List<List<Integer>> result = s.permuteUnique(new int[]{1, 2, 3});
        List<List<Integer>> result = s.permuteUnique(new int[]{1, 1, 2});
        for(List<Integer> e : result){
            System.out.println(e);
        }
    }
}
