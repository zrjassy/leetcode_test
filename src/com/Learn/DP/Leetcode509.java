package com.Learn.DP;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p>斐波那契数列dp实现</p>
 *
 * @author : 你的名字
 * @date : 2023-05-10 17:01
 **/
public class Leetcode509 {
    public static void main(String[] args) {
        int n = 10;
        Leetcode509 lc = new Leetcode509();
        System.out.println(lc.fib(n));
    }

    // 自下往上
    public int fib2(int n) {
        if (n == 0) {
            return 0;
        }
        int[] dp = new int[n + 1];
        // base case
        dp[0] = 0;
        dp[1] = 1;
        // 状态转移
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public int fib(int n) {
        int[] mem = new int[n + 1];
        return dp(mem, n);
    }

    // 自顶向下
    public int dp(int[] mem, int n) {
        // base case
        if (n == 0 || n == 1) return n;
        if (mem[n] != 0) return mem[n];
        mem[n] = dp(mem, n - 1) + dp(mem, n - 2);
        return mem[n];
    }
}
