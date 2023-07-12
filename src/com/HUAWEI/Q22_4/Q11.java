package com.HUAWEI.Q22_4;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 你的名字
 * @date : 2023-05-15 02:11
 **/
public class Q11 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();
        int X = sc.nextInt();

        // dp[i][j]表示运往对岸i只羊和j只狼需要的次数
        int[][] dp = new int[M + 1][N + 1];
        for (int i = 0; i < M + 1; i++) {
            Arrays.fill(dp[i], -1);
        }
        int ans = CrossRiver(M, N, X, 0, 0, dp);
        if (ans == Integer.MAX_VALUE) ans = 0;
        System.out.println(ans);

    }

    public static int CrossRiver(int M, int N, int X, int M_1, int N_1, int[][] dp) {
        if (dp[M_1][N_1] != -1) return dp[M_1][N_1];
        if (M + N <= X) return 1;

        int time = Integer.MAX_VALUE;
        // 运i只羊和j只狼
        for (int i = 0; i <= M - M_1 && i <= X; i++) {
            int temp = Integer.MAX_VALUE;
            for (int j = 0; j <= N - N_1 && j <= X - i; j++) {
                if (i + j == 0) continue;
                if (i < j) continue;
                // 能运的方案要求
                // 对于岸这边，运了i只羊和j只狼后，要么羊运完了，否则羊的数量必须大于狼的数量
                // 对于对岸，运了i只羊和j只狼后，要么此时还没运羊，否则羊的数量也必须大于狼的数量
                if ((M - i == 0 || M - i > N - j) && (M_1 + i > N_1 + j || M_1 + i == 0)) {
                    temp = CrossRiver(M - i, N - j, X, M_1 + i, N_1 + j, dp);
                    if (temp != Integer.MAX_VALUE) temp += 1;
                }
            }
            time = Math.min(time, temp);
        }
        dp[M_1][N_1] = time;

        return time;
    }


}
