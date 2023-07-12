package com.HUAWEI.HandWrite;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 张锐
 * @date : 2023-06-02 02:41
 **/
public class Q1039 {
    public static void main(String[] args) {
        int[][] matrix = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};

        NumMatrix numMatrix = new NumMatrix(matrix);
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4));
    }


    static class NumMatrix {
        int[][] preSum;

        public NumMatrix(int[][] matrix) {
            int n = matrix.length;
            int m = matrix[0].length;
            preSum = new int[n][m];
            preSum[0][0] = matrix[0][0];

            for (int i = 1; i < n; i++) {
                preSum[i][0] = preSum[i - 1][0] + matrix[i][0];
            }
            for (int i = 1; i < m; i++) {
                preSum[0][i] = preSum[0][i - 1] + matrix[0][i];
            }
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    preSum[i][j] = matrix[i][j] + preSum[i - 1][j] + preSum[i][j - 1] - preSum[i - 1][j - 1];
                }
            }
        }

        int sumRegion(int row1, int col1, int row2, int col2) {
            int all = preSum[row2][col2];
            int left = col1 == 0 ? 0 : preSum[row2][col1 - 1];
            int up = row1 == 0 ? 0 : preSum[row1 - 1][col2];
            int small = (left == 0 || up == 0) ? 0 : preSum[row1 - 1][col1 - 1];
            return all - left - up + small;
        }
    }
}
