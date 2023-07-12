package com.Learn.DP.DigitDP;

import java.util.ArrayList;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 你的名字
 * @date : 2023-05-14 03:32
 **/
public class test2 {
    public static void main(String[] args) {
        int l = 10;
        int r = 20;
    }

    static int N = 20;

    static int[][] dp = new int[N][2];
    // dp[len][i] 表示长度为len，第一位数为i，符合要求的数的个数。

    public static void initDP() {
        dp[1][0] = 1;// 0
        dp[1][1] = 1;// 1
        dp[2][0] = 2;// 01  00
        dp[2][1] = 2;// 10  11

        for (int i = 3; i < N; i++) {
            dp[i][0] = dp[i - 1][0] + dp[i - 1][1];
            dp[i][1] = dp[i - 1][0] + dp[i - 1][1] - dp[i - 2][1];
        }
    }

    public static int solve(int x) {
        ArrayList<Integer> ans = new ArrayList<>();
        // 从低位到高位输入数组中
        while (x > 0) {
            ans.add(x % 2);
            x /= 2;
        }
        int pre = 0, prepre = 0;
        int res = 0;

        for (int i = ans.size() - 1; i >=0 ; i--) {
            int a = ans.get(i);

            if (a == 1){
                res += dp[i+1][0];
                if (pre == 1) {
                    res -= dp[i][1];
                } else {
                    if (prepre == 1) {
                        break;
                    }
                }
            }
            prepre = pre;
            pre = a;
            if (i == 0) {
                res += 1;
            }
        }

        return res;
    }
}
