package com.Learn.Leetcode;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p>01矩阵</p>
 *
 * @author : 张锐
 * @date : 2023-05-24 02:32
 **/
public class Q542 {
    public static void main(String[] args) {

    }

    public int[][] updateMatrix(int[][] mat) {
        int N = mat.length;
        int M = mat[0].length;
        int[][] distance = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (mat[i][j] == 0) {
                    distance[i][j] = 0;
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }

        int[][] dists = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        while (!queue.isEmpty()) {
            int[] position = queue.poll();
            int i = position[0];
            int j = position[1];
            for (int[] dis : dists) {
                int x = i + dis[0];
                int y = j + dis[1];
                if (x >= 0 && x <= N && y >= 0 && y <= M && !visited[x][y]) {
                    distance[x][y] = distance[i][j] + 1;
                    queue.offer(new int[]{x, y});
                    visited[x][y] = true;
                }
            }
        }
        return distance;
    }
}
