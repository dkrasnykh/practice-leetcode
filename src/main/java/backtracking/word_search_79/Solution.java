package backtracking.word_search_79;

public class Solution {
    private int ROWS, COLS;
    private int[][] dif = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private boolean dfs(int r, int c, int i, char[][] board, boolean[][] v, String word) {
        if (i == word.length()) {
            return true;
        }
        if (r < 0 || r == ROWS || c < 0 || c == COLS || v[r][c] || board[r][c] != word.charAt(i)) {
            return false;
        }
        boolean result = false;
        for (int[] d : dif) {
            v[r][c] = true;
            result = result || dfs(r + d[0], c + d[1], i + 1, board, v, word);
            v[r][c] = false;
        }
        return result;
    }

    public boolean exist(char[][] board, String word) {
        ROWS = board.length;
        COLS = board[0].length;
        for (int i = 0; i < board.length; ++i) {
            for (int j = 0; j < board[0].length; ++j) {
                boolean[][] v = new boolean[ROWS][COLS];
                if (dfs(i, j, 0, board, v, word)) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        //[["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]]
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E', 'E'}};
        String word = "ABCB";
        System.out.println(s.exist(board, word));
    }
}
