package com.HUAWEI.Q23_1;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 你的名字
 * @date : 2023-05-19 14:16
 **/
public class Q82 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toList();
        System.out.println(MaxFriend(list));
        int friendMax = 0;
        int temp = 0;
        int lianxu1 = 0;
        boolean flag = false; // flag表示是否遇到了一个0
        for (int i = 0; i < list.size(); i++) {
            int x = list.get(i);
            if (x == 1) {
                lianxu1 ++;
            } else if (x == 2){
                lianxu1 = 0;
                flag = false;
            } else if (x == 0) {
                if(!flag) {
                    flag = true;
                    temp += lianxu1;
                } else {
                    temp += lianxu1;
                    friendMax = Math.max(friendMax, temp);
                    temp = lianxu1;
                }
                lianxu1 = 0;
            }

            if ( i == list.size() - 1) {
                if (x == 1 || x == 2) {
                    temp+=lianxu1;
                }
                friendMax = Math.max(friendMax, temp);
            }
        }
        System.out.println(friendMax);
    }

    public static int MaxFriend(List<Integer> nums) {
        int[] dp_left = new int[nums.size()];
        int[] dp_right = new int[nums.size()];
        // dp_left[i]表示i左边的连续1的个数，dp_right[i]表示i右边的连续1的个数
        dp_left[0] = 0;
        dp_right[nums.size() - 1] = 0;
        for (int i = 1; i < nums.size(); i++) {
            if (nums.get(i - 1) == 1) {
                dp_left[i] = dp_left[i-1] + 1;
            } else{
                dp_left[i] = 0;
            }
        }
        for (int i = nums.size() - 2; i >= 0; i--) {
            if (nums.get(i + 1) == 1) {
                dp_right[i] = dp_right[i + 1] + 1;
            } else {
                dp_right[i] = 0;
            }
        }
        int Max = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (nums.get(i) == 0) {
                int temp = dp_left[i] + dp_right[i];
                Max = Math.max(Max, temp);
            }
        }
        return Max;
    }
}
