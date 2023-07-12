package com.Learn.DP.DigitDP;

import java.util.Arrays;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p>数位DP</p>
 *
 * @author : 你的名字
 * @date : 2023-05-13 02:47
 **/
public class test1 {
    public static void main(String[] args) {
        int l = 1;
        int r = 10;
        System.out.println(solve(r));
        System.out.println(solve(l - 1));

    }

    static int N = 20;
    static int[] ans = new int[N];
    // dp[pos][pre][prepre]：长度为pos+1的以prepre pre 开头的符合要求的数的数量
    static int[][][] dp = new int[N][2][2];

    public static int solve(int x) {
        Arrays.fill(ans, 0);
        String s = Integer.toBinaryString(x);
        for (int i = s.length() - 1; i >= 0; i--) {
            ans[i] = s.charAt(s.length() - i - 1) - '0';
        }
        return dfs(s.length() - 1, true, 0, 0);
    }

    public static int dfs(int pos, boolean limit, int Pre, int PretOfPre) {
        if (pos == -1) return 1;
        if (!limit && dp[pos][Pre][PretOfPre] != 0) {
            return dp[pos][Pre][PretOfPre];
        }

        int up = limit ? ans[pos] : 1;
        int count = 0;

        for (int i = 0; i <= up; i++) {
            if (i == 1 && Pre == 0 && PretOfPre == 1) {
                continue;
            }
            count += dfs(pos - 1, limit && i == up, i, Pre);
        }

        if (!limit) {
            dp[pos][Pre][PretOfPre] = count;
        }

        return count;
    }
}
