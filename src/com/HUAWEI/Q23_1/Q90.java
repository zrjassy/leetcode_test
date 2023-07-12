package com.HUAWEI.Q23_1;

import java.util.HashMap;
import java.util.Scanner;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 你的名字
 * @date : 2023-05-19 21:41
 **/
public class Q90 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] logs = new int[n][2];
        for (int i = 0; i < n; i++) {
            logs[i][0] = sc.nextInt();
            logs[i][1] = sc.nextInt();
        }
        int index = sc.nextInt();

        // map <k,v>表示index发给的k的短信有v条
        HashMap<Integer, Integer> map1 = new HashMap<>();
        // map <k,v>表示k发给的index的短信有v条
        HashMap<Integer, Integer> map2 = new HashMap<>();

        int sendNum = 0;
        int receiveNum = 0;

        for (int i = 0; i < n; i++) {
            int send = logs[i][0];
            int receive = logs[i][1];

            if (send == index) {
                sendNum++;
                map1.put(receive, map1.getOrDefault(receive, 0) + 1);
            }
            if (receive == index) {
                receiveNum++;
                map2.put(send, map2.getOrDefault(send, 0) + 1);
            }
        }
        boolean flag = false;
        int L, M, N;
        M = sendNum - receiveNum;
        if (M > 10) {
            flag = true;
        }

        int L0 = map1.size();
        int L1 = 0;
        for (Integer key : map1.keySet()) {
            if (map2.containsKey(key)) {
                L1++;
            }
            N = map1.get(key) - map2.getOrDefault(key, 0);
            if (N > 5) {
                flag = true;
            }
        }
        L = L0 - L1;
        if (L > 5) {
            flag = true;
        }

        System.out.println(flag + " " + L + " " + M);

    }
}
