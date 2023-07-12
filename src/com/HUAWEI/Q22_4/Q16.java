package com.HUAWEI.Q22_4;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 你的名字
 * @date : 2023-05-15 22:15
 **/
public class Q16 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> logs = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toList();
        int[] scores = new int[logs.size()];
        int[] preSum = new int[logs.size()];
        scores[0] = logs.get(0);
        preSum[0] = logs.get(0);
        int maxScore = scores[0];
        for (int i = 1; i < logs.size(); i++) {
            if (preSum[i - 1] >= 100) break;
            preSum[i] = preSum[i - 1] + logs.get(i);
            // 该时刻要提交的日志个数
            int temp = preSum[i] >= 100 ? 100 - preSum[i - 1] : logs.get(i);
            // 当前时刻，在上一时刻的基础下，我们新提交了temp个日志，获得temp * 1分
            // 而与此同时，上一时刻提交的日志如果到这时刻再提交，也就是又晚了1秒，每个日志再多扣 1分，共扣 preSum[i-1] 个日志。
            scores[i] = scores[i - 1] + temp - preSum[i - 1];
            maxScore = Math.max(maxScore, scores[i]);
        }
        System.out.println(maxScore);
    }
}
