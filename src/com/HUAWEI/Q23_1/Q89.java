package com.HUAWEI.Q23_1;

import java.util.*;
import java.util.stream.Stream;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 你的名字
 * @date : 2023-05-19 18:02
 **/
public class Q89 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();
        UF uf = new UF(N);
        int minCost = 0;

        List<int[]> edges = new LinkedList<>();

        for (int i = 0; i < M; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            int money = sc.nextInt();
            edges.add(new int[]{x, y, money});
        }
        if (K > 0) {
            HashSet<Integer> set = new HashSet<>();
            for (int i = 0; i < K; i++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                uf.Union(x, y);
                set.add(10 * x + y);
            }
            for (int[] edge : edges) {
                int x = 10 * edge[0] + edge[1];
                if (set.contains(x)) {
                    minCost += edge[2];
                    edges.remove(edge);
                }
            }
        }
        edges.sort((a, b) -> {
            return a[2] - b[2];
        });

        for (int[] edge : edges) {
            if (!uf.isConnected(edge[0], edge[1])) {
                minCost += edge[2];
                uf.Union(edge[0], edge[1]);
            }
        }
        if (uf.getCount() != 1) {
            System.out.println(-1);
        } else {
            System.out.println(minCost);
        }
    }

    static class UF {
        private int[] parent;
        private int count;

        public UF(int n) {
            parent = new int[n + 1];
            this.count = n;
            for (int i = 1; i < n + 1; i++) {
                parent[i] = i;
            }
        }

        public void Union(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            if (rootJ == rootI) {
                return;
            }
            parent[rootI] = rootJ;
            count--;
        }

        public boolean isConnected(int i, int j) {
            int rootI = find(i);
            int rootJ = find(j);
            return rootI == rootJ;
        }

        private int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        public int getCount() {
            return this.count;
        }
    }
}


