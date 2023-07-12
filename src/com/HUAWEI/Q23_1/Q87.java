package com.HUAWEI.Q23_1;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 你的名字
 * @date : 2023-05-19 16:10
 **/
public class Q87 {
    public static int[][] dirctions = {{1, 0, 1}, {2, 0, -1}, {3, 1, 0}, {4, -1, 0}};
    public static int t, c, N, M;
    public static String[][] matric;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        t = sc.nextInt();
        c = sc.nextInt();
        N = sc.nextInt();
        M = sc.nextInt();
        matric = new String[N][M];
        for (int i = 0; i < N; i++) {
            matric[i] = sc.next().split("");
        }
        System.out.println(Arrays.deepToString(matric));

        // 存放 i * m + j 表示[i，j]点位已走过
        HashSet<Integer> pos = new HashSet<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if ("S".equals(matric[i][j])) {
                    pos.add(i * M + j);
                    if (dfs(pos, i, j, 0, 0, 0)) {
                        System.out.println("YES");
                    } else {
                        System.out.println("NO");
                    }
                    return;
                }
            }
        }
        // 没有S，直接输出NO
        System.out.println("NO");
        return;
    }

    public static boolean dfs(HashSet<Integer> pos, int x, int y, int usedT, int usedC, int lastdirect) {
        if("T".equals(matric[x][y])) {
            return true;
        }

        for (int[] direction: dirctions) {
            int direct = direction[0];
            int add_x = direction[1];
            int add_y = direction[2];
            int new_x = x + add_x;
            int new_y = y + add_y;
            if (new_x >= 0 && new_x <= N && new_y >= 0 && new_y <= M) {
                // 该点位（x,y）已经在该次搜索的路上
                if (pos.contains( new_x * M + new_y)) continue;

                boolean flag_turn = false;
                boolean flag_break = false;

                if (lastdirect !=0 && lastdirect != direct) {
                    if (usedT + 1 > t) {
                        continue;
                    }
                    flag_turn = true;
                }
                if ("*".equals(matric[new_x][new_y])) {
                    if (usedC + 1 > c) {
                        continue;
                    }
                    flag_break = true;
                }

                pos.add(new_x * M + new_y);

                if (dfs(pos, new_x, new_y, flag_turn ? usedT + 1: usedT, flag_break ? usedC + 1:usedC,direct)) {
                    return true;
                }
                pos.remove(new_x * M + new_y);
            }
        }
        return false;
    }
}
