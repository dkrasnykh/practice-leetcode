package arrays_hashing.range_sum_query_2d_immutable_304.solution1;

public class NumMatrix {
    long[][] prefix;

    public NumMatrix(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        prefix = new long[rows + 1][cols + 1];
        for (int i = 0; i < rows; ++i) {
            long prefixLine = 0;
            for (int j = 0; j < cols; ++j) {
                prefixLine += matrix[i][j];
                long above = prefix[i][j + 1];
                prefix[i + 1][j + 1] = prefixLine + above;
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return (int) (prefix[row2 + 1][col2 + 1] - prefix[row1][col2 + 1] - prefix[row2 + 1][col1] + prefix[row1][col1]);
    }
}
