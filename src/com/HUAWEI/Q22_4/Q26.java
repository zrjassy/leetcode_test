package com.HUAWEI.Q22_4;

import java.util.Scanner;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 你的名字
 * @date : 2023-05-17 04:45
 **/
public class Q26 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int days = sc.nextInt();
        int[] MaxProducts = new int[N];
        for (int i = 0; i < N; i++) {
            MaxProducts[i] = sc.nextInt();
        }

        int[][] price = new int[N][days];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < days; j++) {
                price[i][j] = sc.nextInt();
            }
        }

        int profit = 0;
        for (int i = 0; i < days - 1; i++) {
            for (int j = 0; j < N; j++) {
                if (price[j][i+1] > price[j][i]) {
                    profit += MaxProducts[j] * (price[j][i+1] - price[j][i]);
                }
            }
        }
        System.out.println(profit);
    }
}
