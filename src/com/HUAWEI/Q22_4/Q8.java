package com.HUAWEI.Q22_4;

import java.util.Scanner;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 你的名字
 * @date : 2023-05-14 05:16
 **/
public class Q8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s1 = sc.nextLine().split(" ");
        int[] nums = new int[s1.length];
        for (int i = 0; i < s1.length; i++) {
            nums[i] = Integer.parseInt(s1[i]);
        }
        int t = sc.nextInt();

        int[] time = new int[3];

        for (int i = 0; i < t; i++) {
            time[nums[i]]++;
        }
        int max = Math.max(time[0], Math.max(time[1], time[2]));
        for (int i = t; i < s1.length; i++) {
            time[nums[i]]++;
            time[nums[i - t]]--;
            max = Math.max(max, time[nums[i]]);
        }
        System.out.println(max);
    }
}
