package com.Learn.JavaLearn;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 你的名字
 * @date : 2023-05-22 04:03
 **/
public class test3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(solution(n));
    }

    public static List<String> solution(int n) {
        List<String> list = new ArrayList<>();
        list.add("()");
        if (n == 1) return list;

        for (int i = 1; i < n; i++) {
            int len = list.size();
            for (int j = 0; j < len; j++) {
                String temp = list.get(0);
                list.remove(temp);
                list.add(temp + "()");
                list.add("(" + temp + ")");
            }
        }
        return list;
    }
}
