package com.HUAWEI.Q23_1;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 你的名字
 * @date : 2023-05-19 14:48
 **/
public class Q84 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M  = sc.nextInt();
        sc.nextLine();
        List<Integer> list = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toList();
        System.out.println(M);
        System.out.println(list);

        int MaxSum = 0;
        int left = 0, right = 0;
        int window_sum = 0;
        while (right < list.size()) {
            if (list.get(right) > M) {
                right = right + 1;
                left = right;
                window_sum = 0;
                continue;
            }
            if (window_sum + list.get(right) <= M) {
                window_sum += list.get(right);
                right++;
            } else {
                window_sum += list.get(right);
                right++;
                while (window_sum > 0) {
                    window_sum -= list.get(left);
                    left++;
                    if (window_sum <= M) {
                       break;
                    }
                }
            }
            MaxSum = Math.max(MaxSum, window_sum);
            if (MaxSum == M) break;
        }
        System.out.println(MaxSum);
    }
}
