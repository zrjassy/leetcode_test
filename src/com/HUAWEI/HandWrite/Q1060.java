package com.HUAWEI.HandWrite;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 张锐
 * @date : 2023-06-02 01:28
 **/
public class Q1060 {
    public static void main(String[] args) {
        int[][] weights = {{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};

        Q1060 q1060 = new Q1060();
        System.out.println(q1060.maxValue(weights));
    }

    public int maxValue(int[][] weights) {
        int n = weights.length;
        int m = weights[0].length;

        int[][] dp = new int[n][m];
        dp[0][0] = weights[0][0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = dp[i - 1][0] + weights[i][0];
        }
        for (int i = 1; i < m; i++) {
            dp[0][i] = dp[0][i - 1] + weights[0][i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + weights[i][j];
            }
        }
        return dp[n - 1][m - 1];
    }


}
