package com.HUAWEI.HandWrite;

import java.util.Random;
import java.util.Scanner;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 张锐
 * @date : 2023-05-23 02:31
 **/
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long seed = sc.nextLong();
        int n = sc.nextInt();
        Random random = new Random(seed);

        int result = 0;
        for (int i = 0; i < n; i++) {
            // 0~1 -> -1~1
            double x = random.nextDouble() * 2 - 1;
            double y = random.nextDouble() * 2 - 1;

            double len = Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));

            if (len < 1) result++;
        }
        double pai = 4 * (double) result / n;
        System.out.println(pai);
    }
}
