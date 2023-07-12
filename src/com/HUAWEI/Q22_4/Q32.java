package com.HUAWEI.Q22_4;

import java.awt.desktop.SystemEventListener;
import java.util.Arrays;
import java.util.Scanner;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 你的名字
 * @date : 2023-05-16 11:11
 **/
public class Q32 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int h1 = sc.nextInt();
        int m1 = sc.nextInt();
        int T1 = 60 * h1 + m1;
        int h2 = sc.nextInt();
        int m2 = sc.nextInt();
        int T2 = 60 * h2 + m2;

        int N = sc.nextInt();
        // ans[i][0] 距离  ans[i][1] 人数  ans[i][2] 能否满足（0不满足，1满足）  ans[i][3] 拿到核酸结果时间  ans[i][4] 费用 ans[i][5] 编号
        int[][] ans = new int[N + 1][6];
        for (int i = 1; i < N + 1; i++) {
            int index = sc.nextInt();
            int distance = sc.nextInt();
            int number = sc.nextInt();
            ans[index][5] = index;
            ans[index][0] = distance;
            ans[index][1] = number;
        }

        // 定义4个时间区间，0到1和2到3人数会增加，分别是3和10 人/分钟
        int[] timeNode = {480, 600, 720, 840, 1200};

        for (int i = 1; i < N + 1; i++) {
            int getTime = calTime(timeNode, T1, ans[i]);
            if (getTime <= T2) {
                ans[i][2] = 1;
                ans[i][3] = getTime - T1;
                ans[i][4] = 10 * ans[i][0];
            }
        }

        Arrays.sort(ans, (int[] a, int[] b) -> {
            // 如果a[2]不等，把1的排在前面
            if (a[2] != b[2]) {
                return b[2] - a[2];
            } else {
                if (a[3] != b[3]) {
                    return a[3] - b[3];
                } else {
                    if (a[4] != b[4]) {
                        return a[4] - b[4];
                    } else return 0;
                }
            }
        });

        for (int i = 0; i < N; i++) {
            if (ans[i][2] == 1) {
                System.out.println(ans[i][5] + " " + ans[i][3] + " " + ans[i][4]);
            }
        }
    }

    public static int calTime(int[] timeNode, int startTime, int[] node) {
        int getTime = startTime + 10 * node[0];

        for (int i = startTime; i < getTime; i = i + 10) {
            if (i >= timeNode[0] && i <= timeNode[1]) {
                node[1] += 3 * 10;
            } else if (i >= timeNode[2] && i <= timeNode[3]) {
                node[1] += 10 * 10;
            }
            if (node[1] != 0 && i >= timeNode[0] && i < timeNode[4]) {
                node[1] -= 1 * 10;
                if (node[1] < 0) node[1] = 0;
            }
        }
        return getTime + node[1];
    }
}
