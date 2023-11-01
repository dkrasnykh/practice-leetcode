package graphs.rotting_oranges_994;

import java.util.ArrayDeque;

public class Solution {
    private int[][] dif = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    public int orangesRotting(int[][] grid) {
        ArrayDeque<int[]> q = new ArrayDeque<>();
        int rows = grid.length;
        int columns = grid[0].length;
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                if (grid[i][j] == 2) {
                    q.addLast(new int[]{i, j});
                }
            }
        }
        int result = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            while (size > 0) {
                int r = q.getFirst()[0], c = q.pollFirst()[1];
                for (int[] d : dif) {
                    if (r + d[0] >= 0 && r + d[0] < rows && c + d[1] >= 0 && c + d[1] < columns && grid[r + d[0]][c + d[1]] == 1) {
                        grid[r + d[0]][c + d[1]] = 2;
                        q.addLast(new int[]{r + d[0], c + d[1]});
                    }
                }
                size -= 1;
            }
            result += (q.isEmpty() ? 0 : 1);
        }
        for(int i = 0; i < rows; ++i){
            for(int j = 0; j < columns; ++j){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        //[[2,1,1],[1,1,0],[0,1,1]]
        Solution s = new Solution();
        int res =  s.orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}});
        System.out.println(res);
    }
}
