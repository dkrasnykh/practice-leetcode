package graphs.island_perimeter_463;

//https://www.youtube.com/watch?v=fISIuAFRM2s
public class Solution2 {
    private boolean[][] used;

    private int dfs(int i, int j, int[][] grid) {
        if (i >= grid.length || j >= grid[0].length
                || i < 0 || j < 0 || grid[i][j] == 0) {
            return 1;
        }
        if (used[i][j]) {
            return 0;
        }
        used[i][j] = true;
        int p = dfs(i, j + 1, grid);
        p += dfs(i + 1, j, grid);
        p += dfs(i, j - 1, grid);
        p += dfs(i - 1, j, grid);
        return p;
    }

    public int islandPerimeter(int[][] grid) {
        used = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[0].length; ++j) {
                if (grid[i][j] == 1) {
                    return dfs(i, j, grid);
                }
            }
        }
        return 1;
    }

    public static void main(String[] args) {

    }
}
