package com.HUAWEI.Q22_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 你的名字
 * @date : 2023-05-17 04:22
 **/
public class Q24 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        int allMultiply = 1;
        list.add(1);
        String[] str = sc.nextLine().split(" ");
        for (int i = 0; i < str.length; i++) {
            int x = Integer.parseInt(str[i]);
            list.add(x);
            allMultiply *= x;
        }
        list.add(1);

        int left = 1;
        int right = allMultiply;
        int index = -1;
        for (int i = 1; i < list.size() + 1; i++) {
            right /= list.get(i);
            left *= list.get(i - 1);
            if (left == right) {
                index = i - 1;
                break;
            }
        }
        System.out.println(index);
    }
}
