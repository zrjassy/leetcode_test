package com.HUAWEI.Q22_4;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 你的名字
 * @date : 2023-05-14 05:42
 **/
public class Q9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int N = Integer.parseInt(s);
        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < 2 * N; i++) {
            String temp = sc.nextLine();
            list.add(temp);
        }

        int size = 0;
        int count = 0;
        boolean flag = false;
        for (int i = 0; i < 2 * N; i++) {
            String temp = list.get(i);
            if (temp.startsWith("head add")) {
                if (size != 0) {
                    flag = true;
                }
                size++;
            } else if (temp.startsWith("tail add")) {
                size++;
            } else if (temp.startsWith("remove")) {
                if (flag) {
                    count++;
                    flag = false;
                }
                size--;
            }
        }
        System.out.println(count);

    }
}
