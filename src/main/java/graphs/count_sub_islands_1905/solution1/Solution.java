package graphs.count_sub_islands_1905.solution1;

//https://www.youtube.com/watch?v=mLpW3qfbNJ8
public class Solution {
    private boolean dfs(int r, int c, int[][] grid1, int[][] grid2){
        if(r < 0 ||
                c < 0 ||
                r == grid1.length ||
                c == grid1[0].length ||
                grid2[r][c] == 0){
            return true;
        }
        grid2[r][c] = 0;
        boolean res = true;
        if(grid1[r][c] == 0){
            res = false;
        }
        res = dfs(r - 1, c, grid1, grid2) && res;
        res = dfs(r + 1, c, grid1, grid2) && res;
        res = dfs(r, c - 1, grid1, grid2) && res;
        res = dfs(r, c + 1, grid1, grid2) && res;
        return res;
    }
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int count = 0;
        for(int i = 0; i < grid1.length; ++i){
            for(int j = 0; j < grid1[0].length; ++j){
                if(grid2[i][j] == 1 && dfs(i, j, grid1, grid2)){
                    count += 1;
                }
            }
        }
        return count;
    }
}
