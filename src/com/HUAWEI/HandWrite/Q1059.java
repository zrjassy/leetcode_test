package com.HUAWEI.HandWrite;

import java.util.Arrays;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 张锐
 * @date : 2023-06-02 01:37
 **/
public class Q1059 {
    public static void main(String[] args) {
        int n = 5;

        Q1059 q1059 = new Q1059();
        System.out.println(q1059.countOne(n));
    }

    public int countOne(int n) {
        // dp[x] 表示 值x所含有的1的个数
        // dp[x] = dp[x >> 1] + x % 2;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 0; i <= n; i++) {
            dp[i] = dp[i >> 1] + i % 2;
        }
        Arrays.stream(dp).boxed().forEach(System.out::println);
        return Arrays.stream(dp).sum();
    }
}
