package com.HUAWEI.Q22_4;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Timer;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 你的名字
 * @date : 2023-05-16 23:31
 **/
public class Q20 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = sc.nextInt();
        }

        for (int i = N; i >= 1; i--) {
            if (canDivideKSub(nums, i)) {
                System.out.println(i);
                return;
            }
        }
        System.out.println("无法分组");
    }

    public static boolean canDivideKSub(int[] nums, int k) {
        int sum = Arrays.stream(nums).sum();
        if (sum % k != 0) return false;

        int n = nums.length;
        int per = sum / k;
        Arrays.sort(nums);
        if (nums[n - 1] > per) return false;

        // states[S] S为1110011，使用 前5位和后两位,表示该组合是否被查询过，初始均为True,
        boolean[] states = new boolean[1 << n];
        Arrays.fill(states, true);
        int S = (1 << n) - 1;
        int p = 0;

        return dfs(nums, states, per, S, p);
    }

    public static boolean dfs(int[] nums, boolean[] states, int per, int S, int p) {
        if (S == 0) return true;

        if (!states[S]) {
            return states[S];
        }
        states[S] = false;

        for (int i = 0; i < nums.length; i++) {
            // S的第i位被使用过，跳过。
            if (((S >> i) & 1) == 0) continue;

            if (p + nums[i] > per) return false;

            if (dfs(nums, states, per, S ^ (1 << i) , (p + nums[i]) % per)) {
                return true;
            }
        }
        return false;
    }
}
