package com.HUAWEI.Q23_1;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 你的名字
 * @date : 2023-05-19 23:05
 **/
public class Q93 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        sc.nextLine();

        // map存放 路口名称与图节点名称
        HashMap<String, Integer> map = new HashMap<>();

        String[][] packageInfo = new String[N][];
        String[][] checkInfo = new String[M][];

        int index = 1;
        for (int i = 0; i < N; i++) {
            packageInfo[i] = sc.nextLine().split(" ");
            if (!map.containsKey(packageInfo[i][1])) {
                map.put(packageInfo[i][1], index);
                index++;
            }
            if (!map.containsKey(packageInfo[i][2])) {
                map.put(packageInfo[i][1], index);
                index++;
            }
        }
        for (int i = 0; i < M; i++) {
            checkInfo[i] = sc.nextLine().split(" ");
        }

        for (int i = 0; i < N; i++) {
            String name = packageInfo[i][0];
            System.out.println(name.substring(7));
            String from = packageInfo[i][1];
            String to = packageInfo[i][2];
        }



    }

    static class UF {
        int[] parent;
        int count;

        public UF(int n) {
            parent = new int[n + 1];
            count = n;

            for (int i = 1; i < n + 1; i++) {
                parent[i] = i;
            }
        }

        public void Union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootI == rootJ) {
                return;
            }
            parent[rootJ] = rootI;
        }

        public boolean isConnected(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);

            return rootI == rootJ;
        }

        public int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }
    }
}
