package com.Learn.BinarySearch;

import java.util.Random;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p>二分搜索+按权重生成随机数</p>
 *
 * @author : 张锐
 * @date : 2023-05-09 01:12
 **/
public class Leetcode528 {
    public static void main(String[] args) {
        int[] w = {1, 3, 1, 2};
        Solution solution = new Solution(w);
        for (int i = 0; i < 14; i++) {
            System.out.println(solution.pickIndex());
        }
    }

    static class Solution {
        private int[] preSum;
        private Random random = new Random();

        public Solution(int[] w) {
            int n = w.length;
            preSum = new int[n+1];
            preSum[0] = 0;
            for (int i = 1; i <= n; i++) {
                preSum[i] = preSum[i - 1] + w[i-1];
            }
        }

        public int pickIndex() {
            int n = preSum.length;
            // target的范围为[0,preSum[n-1])+1即1到preSum[n-1]的整数
            int target = random.nextInt(preSum[n - 1]) + 1;

            int left = 0, right = n;
            while (left < right) {
                int mid = left + (right - left) / 2;
                if (preSum[mid] == target) {
                    right = mid;
                } else if (preSum[mid] < target) {
                    left = mid + 1;
                } else if (preSum[mid] > target) {
                    right = mid;
                }
            }
            return left - 1;
        }
    }
}
