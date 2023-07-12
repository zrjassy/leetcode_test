package com.Learn.DP;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p>最长递增子序列  和 LC354,二维最长递增</p>
 *
 * @author : 张锐
 * @date : 2023-05-28 04:03
 **/
public class Leetcode300 {
    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        Leetcode300 lc = new Leetcode300();
        System.out.println(lc.lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        // dp[i] 表示以 nums[i] 结尾的最长递增子序列的长度
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }

    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] != o2[0] ? o1[0] - o2[0] : o2[1] - o1[1];
            }
        });
        int[] height = new int[envelopes.length];
        for (int i = 0; i < envelopes.length; i++) {
            height[i] = envelopes[i][1];
        }
        return lengthOfLIS(height);
    }
}
