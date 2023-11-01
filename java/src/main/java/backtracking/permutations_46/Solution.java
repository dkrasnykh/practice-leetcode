package backtracking.permutations_46;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    private void backtrack(List<List<Integer>> result, ArrayDeque<Integer> permut, int[] nums, boolean[] used) {
        if (permut.size() == nums.length) {
            result.add(new ArrayList<>(permut));
        } else {
            for (int i = 0; i < nums.length; ++i) {
                if (used[i]) {
                    continue;
                }
                used[i] = true;
                permut.addLast(nums[i]);
                backtrack(result, permut, nums, used);
                permut.pollLast();
                used[i] = false;
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(result, new ArrayDeque<>(), nums, used);
        return result;
    }

    public static void main(String[] args) {
        /*
        Input: nums = [1,2,3]
        Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
        */
        Solution s = new Solution();
        List<List<Integer>> result = s.permute(new int[]{1, 2, 3});
        for (List<Integer> e : result) {
            System.out.println(e);
        }
    }
}
