package com.HUAWEI.Q23_1;

import java.util.*;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 你的名字
 * @date : 2023-05-19 15:26
 **/
public class Q86 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }
        int P_max = sc.nextInt();
        computeDP(nums, P_max);
        Arrays.sort(nums);
        dfs(nums, 0,0,P_max);
        if (Max == Integer.MIN_VALUE) {
            System.out.println(0);
        } else System.out.println(Max);

    }

    static int Max = Integer.MIN_VALUE;

    public static void dfs(int[] nums, int index, int sum, int P_max) {
        if (index == nums.length) {
            Max = Math.max(Max, sum);
            return;
        }
        Max = Math.max(Max, sum);
        for (int i = index; i < nums.length; i++) {
            if (sum + nums[i] > P_max) {
                return;
            } else {
                dfs(nums, index + 1, sum + nums[i], P_max);
                dfs(nums, index + 1, sum, P_max);
            }
        }
    }

    public static void computeDP(int[] nums, int P_max) {
        int[] dp = new int[nums.length + 1];
        // dp[i] 表示前i个充电设备所能提供的最大不超过P_max的功率
        if (nums[0] > P_max) dp[1] = 0;
        else dp[1] = nums[0];

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > P_max) {
                dp[i + 1] = dp[i];
            } else {
                int max = 0;
                for (int j = 0; j <= i; j++) {
                    if (dp[j] + nums[i] <= P_max) {
                        max = Math.max(max, dp[j] + nums[i]);
                    }
                }
                dp[i+1] = Math.max(max, dp[i]);
            }
        }
        System.out.println(dp[nums.length]);
    }
}
