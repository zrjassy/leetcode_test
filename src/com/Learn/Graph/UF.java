package com.Learn.Graph;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 你的名字
 * @date : 2023-05-19 19:30
 **/
public class UF {
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
}
