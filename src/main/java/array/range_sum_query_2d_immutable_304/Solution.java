package array.range_sum_query_2d_immutable_304;

class NumMatrix {
    private long[][] prefix;
    private int n, m;

    public NumMatrix(int[][] matrix) {
        n = matrix.length;
        m = matrix[0].length;
        prefix = new long[n + 1][m + 1];
        for (int i = 1; i <= n; ++i) {
            for (int j = 1; j <= m; ++j) {
                prefix[i][j] = matrix[i - 1][j - 1] + prefix[i][j - 1];
            }
        }
        for (int j = 1; j <= m; ++j) {
            for (int i = 1; i <= n; ++i) {
                prefix[i][j] += prefix[i - 1][j];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return (int)(prefix[row2 + 1][col2 + 1] - prefix[row1][col2 + 1] - prefix[row2 + 1][col1] + prefix[row1][col1]);
    }
}

public class Solution {
    public static void main(String[] args) {

        int[][] matrix = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};

        NumMatrix newMatrix = new NumMatrix(matrix);
        System.out.println(newMatrix.sumRegion(2, 1, 4, 3));
        /*
        int[][] matrix = {{2, 0, 1}, {1, 0, 1}, {0, 3, 0}};
        NumMatrix newMatrix = new NumMatrix(matrix);
        int test = 5;
        */
    }
}
