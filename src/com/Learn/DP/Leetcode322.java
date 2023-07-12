package com.Learn.DP;

import java.util.Arrays;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p>零钱兑换</p>
 *
 * @author : 你的名字
 * @date : 2023-05-10 17:13
 **/
public class Leetcode322 {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5, 10};
        int amount = 11;
        Leetcode322 lc = new Leetcode322();
        System.out.println(lc.coinChange(coins, amount));
    }

    int[] memo;

    public int coinChange(int[] coins, int amount) {
        memo = new int[amount + 1];
        // 备忘录初始化为一个不会被取到的特殊值，代表还未被计算
        Arrays.fill(memo, -666);

        return dp(coins, amount);
    }

    int dp(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        // 查备忘录，防止重复计算
        if (memo[amount] != -666)
            return memo[amount];

        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            // 计算子问题的结果
            int subProblem = dp(coins, amount - coin);
            // 子问题无解则跳过
            if (subProblem == -1) continue;
            // 在子问题中选择最优解，然后加一
            res = Math.min(res, subProblem + 1);
        }
        // 把计算结果存入备忘录
        memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
        return memo[amount];
    }
}
