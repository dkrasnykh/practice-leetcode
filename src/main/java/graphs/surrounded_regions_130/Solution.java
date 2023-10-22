package graphs.surrounded_regions_130;

public class Solution {
    private int rows, columns;
    private int[][] dif = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    private void dfs(int r, int c, char[][] board, boolean[][] border) {
        if (r < 0 || r == rows || c < 0 || c == columns || board[r][c] == 'X' || border[r][c]) {
            return;
        }
        border[r][c] = true;
        for (int[] d : dif) {
            dfs(r + d[0], c + d[1], board, border);
        }
    }

    public void solve(char[][] board) {
        rows = board.length;
        columns = board[0].length;
        boolean[][] border = new boolean[rows][columns];
        for (int i = 0; i < rows; ++i) {
            dfs(i, 0, board, border);
            dfs(i, columns - 1, board, border);
        }
        for (int j = 0; j < columns; ++j) {
            dfs(0, j, board, border);
            dfs(rows - 1, j, board, border);
        }
        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < columns; ++j) {
                if (board[i][j] == 'O' && !border[i][j]) {
                    board[i][j] = 'X';
                }
            }
        }
    }
}
