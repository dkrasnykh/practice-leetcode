package arrays_hashing.set_matrix_zeroes_73;

import java.util.Arrays;

public class Solution {
    private void setRowZeros(int[][] matrix, int row) {
        Arrays.fill(matrix[row], 0);
    }

    private void setColumnZeros(int[][] matrix, int column) {
        for (int i = 0; i < matrix.length; ++i) {
            matrix[i][column] = 0;
        }
    }

    public void setZeroes(int[][] matrix) {
        boolean isFirstColumn = false;
        for (int i = 0; i < matrix.length; ++i) {
            for (int j = 0; j < matrix[0].length; ++j) {
                if (matrix[i][j] == 0) {
                    if (j == 0) {
                        isFirstColumn = true;
                    } else {
                        matrix[0][j] = 0;
                    }
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = 1; i < matrix.length; ++i) {
            if (matrix[i][0] == 0) {
                setRowZeros(matrix, i);
            }
        }
        for (int j = 1; j < matrix[0].length; ++j) {
            if (matrix[0][j] == 0) {
                setColumnZeros(matrix, j);
            }
        }
        if (matrix[0][0] == 0) {
            setRowZeros(matrix, 0);
        }
        if (isFirstColumn) {
            setColumnZeros(matrix, 0);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.setZeroes(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}});
    }
}
