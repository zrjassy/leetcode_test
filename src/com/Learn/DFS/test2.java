package com.Learn.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class test2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer[] nums = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        test2 t = new test2();
        List<List<Integer>> res = t.permutation(nums);

        System.out.println(res);
        System.out.println(res.size());
    }

    boolean[] visited;

    // 全排列，数组中的数没有重复的
    public List<List<Integer>> permutation(Integer[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        visited = new boolean[nums.length];
        dfs(res, 0, path, nums);
        return res;
    }



    public void dfs(List<List<Integer>> res, int idx, List<Integer> path, Integer[] nums) {
        // 当index等于nums的长度时，说明已经完成一个排列，将这个排列添加进res中。
        if (idx == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i])
                continue;
            path.add(nums[i]);
            visited[i] = true;
            dfs(res, idx + 1, path, nums);
            visited[i] = false;
            path.remove(idx);
        }
    }
}
