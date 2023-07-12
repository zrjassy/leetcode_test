package com.HUAWEI.Q22_4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 你的名字
 * @date : 2023-05-15 21:21
 **/
public class Q14 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int MaxA = sc.nextInt();
        int MaxB = sc.nextInt();
        int MaxC = sc.nextInt();

        int N = sc.nextInt();
        int[] ans = new int[N];

        for (int i = 0; i < N; i++) {
            int x = sc.nextInt();
            int[][] result = new int[4][2];
            result[0] = model_AB(x, MaxA, MaxB >= 1 ? 1 : 0, MaxC);
            result[1] = model_AC(x, MaxA, MaxB >= 1 ? 1 : 0, MaxC);
            result[2] = model_BC(x, MaxA, MaxB >= 1 ? 1 : 0, MaxC);
            result[3] = model_BA(x, MaxA, MaxB >= 1 ? 1 : 0, MaxC);

            Arrays.sort(result, (int[] a, int[] b) -> {
                if (a[0] != b[0]) {
                    return a[0] - b[0];
                } else {
                    return a[1] - b[1];
                }
            });
            ans[i] = result[0][1];
        }

        for (int i = 0; i < N; i++) {
            System.out.println(ans[i]);
        }
    }

    // ans[0] 表示最低价格，ans[1]表示使用的票数
    public static int[] model_AB(int x, int MaxA, int MaxB, int MaxC) {
        int[] ans = new int[2];
        int numA = 0;
        while (numA < MaxA) {
            if (x >= 400) {
                numA++;
                x -= 40;
            } else if (x >= 300) {
                numA++;
                x -= 30;
            } else if (x >= 200) {
                numA++;
                x -= 20;
            } else if (x >= 100) {
                numA++;
                x -= 10;
            } else break;
        }
        ans[1] += numA;
        if (MaxB == 1) {
            x = (int) (x * 0.92);
        }
        ans[1] += MaxB;
        ans[0] = x;
        return ans;
    }

    public static int[] model_AC(int x, int MaxA, int MaxB, int MaxC) {
        int[] ans = new int[2];
        int numA = 0;
        while (numA < MaxA) {
            if (x >= 400) {
                numA++;
                x -= 40;
            } else if (x >= 300) {
                numA++;
                x -= 30;
            } else if (x >= 200) {
                numA++;
                x -= 20;
            } else if (x >= 100) {
                numA++;
                x -= 10;
            } else break;
        }
        ans[1] += numA;

        int numC = 0;
        while (numC < MaxC) {
            x -= 5;
            numC++;
        }
        ans[1] += numC;
        ans[0] = x;
        return ans;
    }

    public static int[] model_BC(int x, int MaxA, int MaxB, int MaxC) {
        int[] ans = new int[2];

        if (MaxB == 1) {
            x = (int) (x * 0.92);
        }
        ans[1] += MaxB;

        int numC = 0;
        while (numC < MaxC) {
            x -= 5;
            numC++;
        }
        ans[1] += numC;
        ans[0] = x;

        return ans;
    }

    public static int[] model_BA(int x, int MaxA, int MaxB, int MaxC) {
        int[] ans = new int[2];

        if (MaxB == 1) {
            x = (int) (x * 0.92);
        }
        ans[1] += MaxB;

        int numA = 0;
        while (numA < MaxA) {
            if (x >= 400) {
                numA++;
                x -= 40;
            } else if (x >= 300) {
                numA++;
                x -= 30;
            } else if (x >= 200) {
                numA++;
                x -= 20;
            } else if (x >= 100) {
                numA++;
                x -= 10;
            } else break;
        }
        ans[1] += numA;
        ans[0] = x;

        return ans;
    }
}
