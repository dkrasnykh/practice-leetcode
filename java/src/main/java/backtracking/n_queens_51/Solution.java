package backtracking.n_queens_51;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {
    private void addSolution(List<List<String>> result, List<int[]> sol) {
        List<String> tmp = new ArrayList<>();
        for (int i = 0; i < sol.size(); ++i) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < sol.size(); ++j) {
                if (sol.get(i)[0] == i && sol.get(i)[1] == j) {
                    sb.append('Q');
                } else {
                    sb.append('.');
                }
            }
            tmp.add(sb.toString());
        }
        result.add(tmp);
    }

    private void dfs(int ind, int n,
                     List<List<String>> result,
                     List<int[]> sol,
                     Set<Integer> rows,
                     Set<Integer> cols,
                     Set<Integer> diag1,
                     Set<Integer> diag2) {
        if (sol.size() == n) {
            addSolution(result, sol);
            return;
        }

        for (int j = 0; j < n; ++j) {
            if (!rows.contains(ind) && !cols.contains(j) &&
                    !diag1.contains(ind - j) && !diag2.contains(ind + j)) {
                sol.add(new int[]{ind, j});
                rows.add(ind);
                cols.add(j);
                diag1.add(ind - j);
                diag2.add(ind + j);
                dfs(ind + 1, n, result, sol, rows, cols, diag1, diag2);
                sol.remove(sol.size() - 1);
                rows.remove(ind);
                cols.remove(j);
                diag1.remove(ind - j);
                diag2.remove(ind + j);
            }
        }
    }

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        dfs(0, n, result, new ArrayList<>(), new HashSet<>(), new HashSet<>(), new HashSet<>(), new HashSet<>());
        return result;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<List<String>> res = s.solveNQueens(4);
        for (List<String> e : res) {
            System.out.println(e);
        }
    }
}
