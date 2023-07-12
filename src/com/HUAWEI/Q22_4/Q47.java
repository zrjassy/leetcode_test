package com.HUAWEI.Q22_4;

import java.util.Scanner;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 你的名字
 * @date : 2023-05-16 10:59
 **/
public class Q47 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s = sc.nextInt();
        int t = sc.nextInt();
        int a = sc.nextInt();
        int b = sc.nextInt();

        int i = 0;
        int j0_b = Math.abs(t - (s- a * i));
        int j1_b = Math.abs(t - (s + a * i));

        while (j0_b % b != 0 && j1_b % b != 0) {
            i++;
            j0_b = Math.abs(t - (s- a * i));
            j1_b = Math.abs(t - (s + a * i));
        }
        System.out.println(i);
    }
}
