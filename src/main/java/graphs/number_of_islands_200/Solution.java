package graphs.number_of_islands_200;

public class Solution {
    private void dfs(char[][] grid, int r, int c){
        if (r < 0
                || r >= grid.length
                || c < 0
                || c >= grid[0].length
                || grid[r][c] == '0'){
            return;
        }
        grid[r][c] = '0';
        dfs(grid, r - 1, c);
        dfs(grid, r + 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r, c + 1);
    }

    public int numIslands(char[][] grid) {
        int result = 0;
        for(int r = 0; r < grid.length; ++r){
            for(int c = 0; c < grid[0].length; ++c){
                if(grid[r][c] == '1'){
                    dfs(grid, r, c);
                    result += 1;
                }
            }
        }
        return result;
    }
}
