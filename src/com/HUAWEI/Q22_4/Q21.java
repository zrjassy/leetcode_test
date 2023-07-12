package com.HUAWEI.Q22_4;

import java.util.HashMap;
import java.util.Scanner;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 你的名字
 * @date : 2023-05-17 03:02
 **/
public class Q21 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HashMap<Integer, Integer> hashMap1 = new HashMap<>();
        HashMap<Integer, Integer> hashMap2 = new HashMap<>();

        int M = sc.nextInt();
        for (int i = 0; i < M; i++) {
            int temp = sc.nextInt();
            hashMap1.put(temp, hashMap1.getOrDefault(temp, 0) + 1);
        }
        int N = sc.nextInt();
        for (int i = 0; i < N; i++) {
            int temp = sc.nextInt();
            hashMap2.put(temp, hashMap2.getOrDefault(temp, 0) + 1);
        }

        int result = 0;
        for (Integer key : hashMap1.keySet()) {
            if (hashMap2.containsKey(key)) {
                result += hashMap1.get(key) * hashMap2.get(key);
            }
        }
        System.out.println(result);
    }
}
