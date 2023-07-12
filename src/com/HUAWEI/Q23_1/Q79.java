package com.HUAWEI.Q23_1;

import java.util.Arrays;
import java.util.Scanner;

/* Q79 农场施肥
* 题目描述
* 某农场主管理了一大片果园，fields表示不同果林的面积，单位:m^2,现在要为所有的果林施肥且必须在n天之内完成，否则影响收成。
* 小布是果林的工作人员，他每次选择一片果林进行施肥，且一片果林施肥完后当天不再进行施肥作业。
* 假设施肥机的能效为k，单位:m^2/day,请问至少租赁能效k为多少的施肥机才能确保不影响收成?如果无法完成施肥任务，则返回-1。
* 输入描述
* 第一行输入为m和n, m表示fields中的元素个数，n表示施肥任务必须在n天内(含n天)完成
* 第二行输入为fields, fields[i]表示果林i的面积， 单位: m^2
* 输出描述
* 对于每组数据，输出最小施肥机的能效k,无多余空格。
*
* 备注
* 1 ≤ fields.length ≤ 10^4
* 1 ≤ fields[i] ≤ 10^9
*
* 示例1:
* 输入
* 5 7
* 5 7 9 15 10
* 输出
* 9
* 说明
* 当能效k为9时，fields[0]需要1天，fields[1]需要1天，fields[2]需要1天，fields[3]需要2天，fields[4]需要2天，共需要7天，不会影响收成。
* 示例2:
输入
* 3 1
* 2 3 4
* 输出
* -1
* 说明
* 由于一天最多完成一片果林的施肥，无论k为多少都至少需要3天才能完成施肥，因此返回-1.
* */
public class Q79 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[] fields = new int[m];
        for (int i = 0; i < m; i++) {
            fields[i] = sc.nextInt();
        }
        System.out.println(Solution1(m, n, fields));
    }

    public static int Solution1(int m, int n, int[] fields) {
        // 当果林的个数大于施肥的天数n时，k再大也无法完成。
        if (m > n) return -1;

        Arrays.sort(fields);

        // 当果林的个数等于施肥的天数n时，最小的能效k即为面积的最大值。
        if (m == n) return fields[fields.length - 1];

        int left = 0;
        int right = fields[fields.length - 1];

        while (left + 1 < right) {
            int k = (left + right) / 2;
            int days = 0;
            for (int i = 0; i < m; i++) {
                days += Math.ceil(fields[i] / (double) k);
            }
            if (days > n) left = k;
            else right = k;
        }
        return right;
    }
}
