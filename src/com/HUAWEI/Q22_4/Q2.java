package com.HUAWEI.Q22_4;

import java.util.Arrays;
import java.util.Scanner;

// https://blog.csdn.net/misayaaaaa/article/details/127972503
public class Q2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int w = sc.nextInt();
        int n = sc.nextInt();

        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        Arrays.sort(nums);
        int left = 0;
        int right = n - 1;
        int min_bikes = 0;

        while (left < right) {
            int temp = nums[left] + nums[right];
            if (temp > w) {
                right--;
                min_bikes++;
            } else {
                right--;
                left++;
                min_bikes++;
            }
        }
        if (left == right) min_bikes++;
        System.out.println(min_bikes);
    }
}
