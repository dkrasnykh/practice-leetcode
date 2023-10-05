package arrays_hashing.validSudoku;

//https://leetcode.com/problems/valid-sudoku/
public class Solution {
    public boolean checkBlock(int r, int c, char[][] board) {
        int[] check = new int[10];
        for (int i = r; i < r + 3; i++) {
            for (int j = c; j < c + 3; j++) {
                if (board[i][j] != '.') {
                    if (check[Integer.parseInt(String.valueOf(board[i][j]))] > 0) {
                        return false;
                    }
                    check[Integer.parseInt(String.valueOf(board[i][j]))]++;
                }
            }
        }
        return true;
    }

    public boolean checkRow(int r, char[][] board) {
        int[] check = new int[10];
        for (int j = 0; j < 9; j++) {
            char c = board[r][j];
            if (c != '.') {
                int v = Integer.parseInt(String.valueOf(c));
                if (check[v] > 0) {
                    return false;
                }
                check[v]++;
            }

        }
        return true;
    }

    public boolean checkColumn(int c, char[][] board) {
        int[] check = new int[10];
        for (int i = 0; i < 9; i++) {
            char c1 = board[i][c];
            if (c1 != '.') {
                int v = Integer.parseInt(String.valueOf(c1));
                if (check[v] > 0) {
                    return false;
                }
                check[v]++;
            }
        }
        return true;
    }

    public boolean isValidSudoku(char[][] board) {
        boolean isValid = true;
        for (int i = 0; i < 9; i++) {
            isValid = checkRow(i, board);
            if (!isValid) {
                //System.out.println("Row: "+i);
                return false;
            }
            isValid = checkColumn(i, board);
            if (!isValid) {
                //System.out.println("Column: "+i);
                return false;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                isValid = checkBlock(i * 3, j * 3, board);
                if (!isValid) {
                    //System.out.println("Block: i="+i*3+"; j="+j*3);
                    return false;
                }
            }
        }
        return isValid;
    }

    public static void main(String[] args) {
        char[][] board =
                {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                        , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                        , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(new Solution().isValidSudoku(board));
        board =
                new char[][]{{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                        , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                        , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                        , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                        , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                        , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                        , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                        , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                        , {'.', '.', '6', '.', '8', '.', '.', '7', '9'}};
        System.out.println(new Solution().isValidSudoku(board));


    }
}
