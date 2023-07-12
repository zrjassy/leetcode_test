package com.HUAWEI.Q23_1;

import java.util.Scanner;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 你的名字
 * @date : 2023-05-20 00:50
 **/
public class Q98 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[][] data = new int[N+1][N+1];
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                data[i][j] = sc.nextInt();
            }
        }
        int node = sc.nextInt();

        System.out.println(dfs(N, node, data));

    }

    public static int dfs(int N, int node, int[][] data) {
        int res = 0;
        for (int i = 0; i < N; i++) {
            if (i != node && data[node][i] != 0) {
                res = Math.max(res, dfs(N, i, data));
            }
        }
        return data[node][node] + res;
    }
}
