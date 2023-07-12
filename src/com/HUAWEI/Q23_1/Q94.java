package com.HUAWEI.Q23_1;

import java.util.Arrays;
import java.util.Scanner;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 你的名字
 * @date : 2023-05-19 23:39
 **/
public class Q94 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.nextLine();
        Integer[] nums = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        int[][] count = new int[num][3]; // count[i][0]表示打卡次数，1表示首次打卡日期,2表示员工标号

        for (int i = 0; i < 30; i++) {
            for (int j = 0; j < nums[i]; j++) {
                int index = sc.nextInt();
                count[index][2] = index;
                if (count[index][0] == 0) {
                    count[index][1] = i;
                }
                count[index][0]++;
            }
        }
        Arrays.sort(count, (a,b)->{
            if (a[0] == b[0]) {
                if (a[1] == b[1]) {
                    return a[2] - b[2];
                } else {
                    return a[1] - b[1];
                }
            } else {
                return b[0] - a[0];
            }
        });

        int top = 0;
        for (int i = 0; i < count.length; i++) {
            if (count[i][0] == 0) {
                break;
            } else {
                if (top <= 5) {
                    System.out.println(count[i][2] + " ");
                    top++;
                } else {
                    break;
                }
            }
        }
    }
}
