package com.HUAWEI.Q23_1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 你的名字
 * @date : 2023-05-19 23:56
 **/
public class Q95 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<Integer> integers = new ArrayList<>();
        int[][] nums = new int[N][2];
        int Max_station = 0;
        for (int i = 0; i < N; i++) {
            nums[i][0] = sc.nextInt();
            nums[i][1] = sc.nextInt();
            Max_station = Math.max(Max_station, Math.max(nums[i][0], nums[i][1]));
        }
        for (int i = 0; i < Max_station + 1; i++) {
            integers.add(0);
        }
        for (int i = 0; i < N; i++) {
            if (nums[i][1] > nums[i][0]) {
                for (int j = nums[i][0]; j <= nums[i][1]; j++) {
                    integers.set(j, integers.get(j) + 1);
                }
            } else {
                for (int j = nums[i][0]; j <= Max_station; j++) {
                    integers.set(j, integers.get(j) + 1);
                }
                for (int j = 0; j <= nums[i][1]; j++) {
                    integers.set(j, integers.get(j) + 1);
                }
            }
        }

        int maxNum = 0;
        int pos = 0;
        for (int i = 1; i <= Max_station; i++) {
            if (integers.get(i) > maxNum) {
                maxNum = integers.get(i);
                pos = i;
            }
        }
        System.out.println(pos);

    }
}
