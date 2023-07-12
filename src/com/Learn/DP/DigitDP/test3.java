package com.Learn.DP.DigitDP;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 你的名字
 * @date : 2023-05-14 04:17
 **/
public class test3 {
    public static void main(String[] args) {
        int l = 25;
        int r = 50;
        initDp();
        if (l == 1) {
            System.out.println(solve(r));
        } else {
            System.out.println(solve(r) - solve(l - 1));
        }
    }

    static int N = 10;
    static int[][] dp = new int[N + 1][10];
    // dp[len][i] 表示长度为len，第一个数是i的满足要求的数的个数

    public static void initDp() {
        Arrays.fill(dp[1], 1);
        for (int i = 2; i < N; i++) {
            for (int j = 0; j < 10; j++) {
                for (int k = 0; k < 10; k++) {
                    if (j == 0 && k != 0) {
                        dp[i][j] += dp[i - 1][k];
                    }
                    if (j != 0 && Math.abs(j - k) >= 2) {
                        dp[i][j] += dp[i - 1][k];
                    }
                }
            }
        }
    }

    public static int solve(int x) {
        ArrayList<Integer> ans = new ArrayList<>();
        while (x > 0) {
            ans.add(x % 10);
            x /= 10;
        }
        int res = 0;
        int last = -1;
        for (int i = ans.size() - 1; i >= 0; i--) {
            for (int j = 0; j < ans.get(i); j++) {
                if (last == -1) {
                    res += dp[i + 1][j];
                } else {
                    if (Math.abs(j - last) >= 2) {
                        res += dp[i + 1][j];
                    }
                }
            }
            if (i == 0 && Math.abs(ans.get(i) - last) >= 2) {
                res += 1;
            }
            last = ans.get(i);
        }

        return res;
    }
}
