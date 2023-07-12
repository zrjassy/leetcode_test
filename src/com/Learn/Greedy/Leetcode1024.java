package com.Learn.Greedy;

import java.util.Arrays;
import java.util.Map;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 你的名字
 * @date : 2023-05-17 03:19
 **/
public class Leetcode1024 {
    public static void main(String[] args) {
        int[][] x = {{5, 7}, {1, 8}, {0, 0}, {2, 3}, {4, 5}, {0, 6}, {5, 10}, {7, 10}};
        int time = 5;
        Leetcode1024 leetcode1024 = new Leetcode1024();
        System.out.println(leetcode1024.videoStitching(x, time));
    }

    public int videoStitching1(int[][] clips, int time) {
        int[] dp = new int[time + 1];
        Arrays.fill(dp, Integer.MAX_VALUE - 1);
        dp[0] = 0;

        for (int i = 1; i <= time; i++) {
            for (int[] clip : clips) {
                if (clip[0] < i && i <= clip[1]) {
                    dp[i] = Math.min(dp[i], dp[clip[0]] + 1);
                }
            }
        }
        return dp[time] == Integer.MAX_VALUE - 1 ? -1 : dp[time];
    }

    public int videoStitching(int[][] clips, int time) {
        Arrays.sort(clips, (a, b) -> {
            if (a[0] == b[0]) {
                return a[1] - b[1];
            } else {
                return a[0] - b[0];
            }
        });

        int result = 1;
        int left = 0, right = 0;

        if (clips[0][0] != 0) return -1;
        while (clips[left][0] == 0) {
            left++;
        }
        left--;
        right = left;
        while (clips[right][1] < time) {
            for (int i = left + 1; i < clips.length; i++) {
                if (clips[i][1] <= clips[left][1]) continue;
                if (clips[i][0] <= clips[left][1]) {
                    right = i;
                } else {
                    break;
                }
            }
            if (right != left) {
                left = right;
                result++;
            } else break;
            if (right == clips.length - 1) break;
        }
        if (clips[right][1] < time) return -1;
        else return result;
    }
}
