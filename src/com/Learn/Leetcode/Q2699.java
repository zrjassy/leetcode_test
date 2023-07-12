package com.Learn.Leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 张锐
 * @date : 2023-06-09 23:28
 **/
public class Q2699 {
    public static void main(String[] args) {
        int n = 5;
        int[][] edges = {{4, 1, -1}, {2, 0, -1}, {0, 3, -1}, {4, 3, -1}};
        int source = 0;
        int destination = 1;
        int target = 5;

        Q2699 q2699 = new Q2699();
        int[][] ans = q2699.modifiedGraphEdges(n, edges, source, destination, target);
        System.out.println(Arrays.deepToString(ans));
    }

    public int[][] modifiedGraphEdges(int n, int[][] edges, int source, int destination, int target) {
        return new int[5][5];
    }
}
