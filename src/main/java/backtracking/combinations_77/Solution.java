package backtracking.combinations_77;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    private void generate(int i, int n, int k, List<List<Integer>> result, ArrayDeque<Integer> e) {
        if (e.size() == k) {
            result.add(new ArrayList<>(e));
            return;
        }
        if (i > n) {
            return;
        }
        e.addLast(i);
        generate(i + 1, n, k, result, e);
        e.pollLast();
        generate(i + 1, n, k, result, e);
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        generate(1, n, k, result, new ArrayDeque<>());
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<Integer>> result = s.combine(4, 2);
        for(List<Integer> e : result){
            System.out.println(e);
        }
    }
}
