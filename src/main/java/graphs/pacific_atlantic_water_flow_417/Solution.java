package graphs.pacific_atlantic_water_flow_417;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    private int rows, columns;
    private int[][] dif = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private void dfs(int prevr, int prevc, int r, int c, int[][] heights, boolean[][] ocean) {
        if (r < 0 ||
                r == rows ||
                c < 0 ||
                c == columns ||
                ocean[r][c] ||
                heights[prevr][prevc] > heights[r][c]) {
            return;
        }
        ocean[r][c] = true;
        for (int[] d : dif) {
            dfs(r, c, r + d[0], c + d[1], heights, ocean);
        }
    }

    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        rows = heights.length;
        columns = heights[0].length;
        boolean[][] pacific = new boolean[rows][columns];
        boolean[][] atlantic = new boolean[rows][columns];
        for (int i = 0; i < rows; ++i) {
            dfs(i, 0, i, 0, heights, pacific);
            dfs(i, columns - 1, i, columns - 1, heights, atlantic);
        }
        for (int j = 0; j < columns; ++j) {
            dfs(0, j, 0, j, heights, pacific);
            dfs(rows - 1, j, rows - 1, j, heights, atlantic);
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(new ArrayList<>(List.of(i, j)));
                }
            }
        }
        return result;
    }
}
