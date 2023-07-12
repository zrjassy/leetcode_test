package com.Learn.DFS;

import java.util.Arrays;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 你的名字
 * @date : 2023-05-11 03:59
 **/
public class Leetcode698 {
    public static void main(String[] args) {

    }

    int[] nums;
    int per, n;
    boolean[] dp;

    public boolean canPartitionKSubsets(int[] nums, int k) {
        this.nums = nums;
        int all = Arrays.stream(nums).sum();
        if (all % k != 0) return false;
        per = all / k;
        Arrays.sort(nums);
        n = nums.length;
        if (nums[n - 1] > per) return false;
        dp = new boolean[1 << n];
        Arrays.fill(dp, true);
        // s的二进制为n个1，表示n个数均未被使用，p表示当前实验的集合的和
        return dfs((1 << n) - 1, 0);
    }

    public boolean dfs(int s, int p) {
        if (s == 0) return true;

        if (!dp[s]) {
            return dp[s];
        }
        dp[s] = false;

        for (int i = 0; i < n; i++) {
            if (((s>>i) & 1) == 0) continue;
            if (nums[i] + p > per) return false;
            // 还有数没有用完，s^(1<<i)表示使用掉第i个数，同时当前实验的集合的和加上这个数再模per
            if(dfs(s^(1<<i), (p+nums[i]) % per)) {
                return true;
            }
        }
        return false;
    }
}
