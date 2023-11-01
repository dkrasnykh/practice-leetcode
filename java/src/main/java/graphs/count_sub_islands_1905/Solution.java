package graphs.count_sub_islands_1905;

public class Solution {
    private void dfs1(int r, int c, int[][] grid1, int[][] grid2) {
        if (r < 0 || r >= grid1.length || c < 0 || c >= grid1[0].length || grid1[r][c] == 0) {
            return;
        }
        grid2[r][c] = (grid2[r][c] == 1 ? 2 : grid2[r][c]);
        grid1[r][c] = 0;
        dfs1(r - 1, c, grid1, grid2);
        dfs1(r, c + 1, grid1, grid2);
        dfs1(r + 1, c, grid1, grid2);
        dfs1(r, c - 1, grid1, grid2);
    }

    private void dfs2(int r, int c, int[][] grid2, boolean[] ans) {
        if (r < 0 || r >= grid2.length || c < 0 || c >= grid2[0].length || grid2[r][c] == 0) {
            return;
        }
        if (grid2[r][c] == 1) {
            ans[0] = true;
        }
        grid2[r][c] = 0;
        dfs2(r - 1, c, grid2, ans);
        dfs2(r, c + 1, grid2, ans);
        dfs2(r + 1, c, grid2, ans);
        dfs2(r, c - 1, grid2, ans);
    }

    public int countSubIslands(int[][] grid1, int[][] grid2) {
        for (int i = 0; i < grid1.length; ++i) {
            for (int j = 0; j < grid1[0].length; ++j) {
                if (grid1[i][j] == 1) {
                    dfs1(i, j, grid1, grid2);
                }
            }
        }
        int subs = 0;
        for (int i = 0; i < grid2.length; ++i) {
            for (int j = 0; j < grid2[0].length; ++j) {
                if (grid2[i][j] == 2) {
                    boolean[] ans = new boolean[1];
                    dfs2(i, j, grid2, ans);
                    if (!ans[0]) {
                        subs += 1;
                    }
                }
            }
        }
        return subs;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        int[][] grid1 = {{1, 1, 1, 1, 0, 0}, {1, 1, 0, 1, 0, 0}, {1, 0, 0, 1, 1, 1}, {1, 1, 1, 0, 0, 1}, {1, 1, 1, 1, 1, 0}, {1, 0, 1, 0, 1, 0}, {0, 1, 1, 1, 0, 1}, {1, 0, 0, 0, 1, 1}, {1, 0, 0, 0, 1, 0}, {1, 1, 1, 1, 1, 0}};
        int[][] grid2 = {{1, 1, 1, 1, 0, 1}, {0, 0, 1, 0, 1, 0}, {1, 1, 1, 1, 1, 1}, {0, 1, 1, 1, 1, 1}, {1, 1, 1, 0, 1, 0}, {0, 1, 1, 1, 1, 1}, {1, 1, 0, 1, 1, 1}, {1, 0, 0, 1, 0, 1}, {1, 1, 1, 1, 1, 1}, {1, 0, 0, 1, 0, 0}};
        System.out.println(s.countSubIslands(grid1, grid2));
    }
}
