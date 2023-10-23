package graphs.rotting_oranges_994.solution1;

import java.util.ArrayDeque;

//https://www.youtube.com/watch?v=y704fEOx0s0
public class Solution {
    public int orangesRotting(int[][] grid) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int time = 0, fresh = 0;
        int ROWS = grid.length, COLS = grid[0].length;
        for (int r = 0; r < ROWS; ++r) {
            for (int c = 0; c < COLS; ++c) {
                if (grid[r][c] == 1) {
                    fresh += 1;
                }
                if (grid[r][c] == 2) {
                    q.addLast(new int[]{r, c});
                }
            }
        }
        int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
        while(!q.isEmpty() && fresh > 0){
            int size = q.size();
            for(int i = 0; i < size; ++i){
                int r = q.getFirst()[0], c = q.pollFirst()[1];
                for(int[] d : directions){
                    int row = d[0] + r, col = d[1] + c;
                    if(row < 0 || row == ROWS || col < 0 || col == COLS || grid[row][col] != 1){
                        continue;
                    }
                    grid[row][col] = 2;
                    q.addLast(new int[]{row, col});
                    fresh -= 1;
                }
            }
            time += 1;
        }
        return fresh == 0 ? time : -1;
    }
}
