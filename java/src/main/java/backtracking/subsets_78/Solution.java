package backtracking.subsets_78;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private void generate(int i, int[] nums, int[] sol, List<List<Integer>> result) {
        if (i == nums.length) {
            List<Integer> subset = new ArrayList<>();
            for (int j = 0; j < nums.length; ++j) {
                if (sol[j] == 1) {
                    subset.add(nums[j]);
                }
            }
            result.add(subset);
        } else {
            for(int k = 0; k < 2; ++k){
                sol[i] = k;
                generate(i + 1, nums, sol, result);
            }
        }
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int[] sol = new int[nums.length];
        generate(0, nums, sol, result);
        return result;
    }
}
