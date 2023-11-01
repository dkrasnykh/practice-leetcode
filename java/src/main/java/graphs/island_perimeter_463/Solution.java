package graphs.island_perimeter_463;

public class Solution {
    private int numberOfNeighbors(int[][] grid, int i, int j) {
        return ((i > 0) ? grid[i - 1][j] : 0)
                + ((i < grid.length - 1) ? grid[i + 1][j] : 0)
                + ((j > 0) ? grid[i][j - 1] : 0)
                + ((j < grid[i].length - 1) ? grid[i][j + 1] : 0);
    }

    public int islandPerimeter(int[][] grid) {
        int p = 0;
        for (int i = 0; i < grid.length; ++i) {
            for (int j = 0; j < grid[i].length; ++j) {
                if (grid[i][j] == 1) {
                    p += 4 - numberOfNeighbors(grid, i, j);
                }
            }
        }
        return p;
    }

    public static void main(String[] args) {

    }
}
