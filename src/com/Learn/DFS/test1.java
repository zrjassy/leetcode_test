package com.Learn.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer[] nums = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);

        test1 t = new test1();
        List<List<Integer>> res = t.permuteUnique(nums);

        System.out.println(res);
        System.out.println(res.size());
    }

    boolean[] visited;

    public List<List<Integer>> permuteUnique(Integer[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        visited = new boolean[nums.length];
        Arrays.sort(nums);
        dfs(res, 0, path, nums);
        return res;
    }

    public void dfs(List<List<Integer>> res, int idx, List<Integer> path, Integer[] nums) {
        if (idx == nums.length) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] || (i > 0 && nums[i] == nums[i - 1] && visited[i - 1])) {
                continue;
            }
            path.add(nums[i]);
            visited[i] = true;
            dfs(res, idx + 1, path, nums);
            visited[i] = false;
            path.remove(idx);
        }
    }
}
