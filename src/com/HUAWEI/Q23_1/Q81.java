package com.HUAWEI.Q23_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// https://renjie.blog.csdn.net/article/details/128585901
public class Q81 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int targetNum = sc.nextInt();
        int relationNum = sc.nextInt();

        int[][] relations = new int[relationNum][2];
        for (int i = 0; i < relationNum; i++) {
            relations[i][0] = sc.nextInt();
            relations[i][1] = sc.nextInt();
        }

        int[] up = new int[targetNum];
        List<List<Integer>> down = new ArrayList<>(targetNum);

        for (int i = 0; i < targetNum; i++) {
            down.add(new ArrayList<>());
        }

        for (int[] relate : relations) {
            up[relate[1]] += 1;
            down.get(relate[0]).add(relate[1]);
        }
        System.out.println(Arrays.toString(up));
        System.out.println(down);


    }

}
