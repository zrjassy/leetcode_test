package com.Learn.DFS;

import java.util.Arrays;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 你的名字
 * @date : 2023-05-11 04:52
 **/
public class Leetcode698_2 {
    public static void main(String[] args) {
        int[] nums = {730, 580, 401, 659, 5524, 405, 1601, 3, 383, 4391, 4485, 1024, 1175, 1100, 2299, 3908};
        int k = 4;
        System.out.println(canPartitionKSubsets(nums, k));
    }

    public static boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;

        int per = sum / k;
        Arrays.sort(nums);
        int n = nums.length;
        if (nums[n - 1] > per) return false;

        // dp[s]表示，例如s为111000111，表示使用了前三个数和后三个数的情况下，当前使用数字之和模per
        int[] dp = new int[1 << n];
        boolean[] dp2 = new boolean[1 << n];
        dp2[0] = true;
        for (int i = 0; i < 1 << n; i++) {
            if (!dp2[i]) {
                continue;
            }
            for (int j = 0; j < n; j++) {
                if (dp[i] + nums[j] > per) break;
                if (((i >> j) & 1) == 0) {
                    int s = i | 1 << j;
                    if (!dp2[s]) {
                        dp[s] = (dp[i] + nums[j]) % per;
                        dp2[s] = true;
                    }
                }
            }
        }
        System.out.println(dp[(1 << n) - 1]);
        return dp2[(1 << n) - 1];
    }
}
