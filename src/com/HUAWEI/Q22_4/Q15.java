package com.HUAWEI.Q22_4;

import java.util.Scanner;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 你的名字
 * @date : 2023-05-15 21:50
 **/
public class Q15 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int C = sc.nextInt();
        int k = sc.nextInt();

        int[][] nums = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                nums[i][j] = sc.nextInt();
            }
        }

        int result = 0;
        if (N >= C && M >= C) {
            result = find(nums, N, M, C, k);
        }
        System.out.println(result);
    }

    public static int find(int[][] nums, int N, int M, int C, int k) {
        // 二维前缀和，p[i][j] 表示 以nums[i -1][j-1]为矩阵最右下角的最大矩阵的和
        int[][] p = new int[N + 1][M + 1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                p[i][j] = p[i - 1][j] + p[i][j - 1] - p[i - 1][j - 1] + nums[i - 1][j - 1];
            }
        }

        int ans = 0;
        for (int i = C; i <= N; i++) {
            for (int j = C; j <= M; j++) {
                int sum = p[i][j] - p[i - C][j] - p[i][j - C] + p[i - C][j - C];
                if (sum >= k) ans++;
            }
        }
        return ans;
    }
}
