package com.Learn.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

// 组合总数
public class leetcode39 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int target = Integer.parseInt(sc.nextLine());

        String[] s = sc.nextLine().split(" ");
        Integer[] candidates = new Integer[s.length];
        for (int i = 0; i < s.length; i++) {
            candidates[i] = Integer.parseInt(s[i]);
        }

        leetcode39 lc39 = new leetcode39();
        List<List<Integer>> res = lc39.combinationSum(candidates, target);
        System.out.println(res);
        System.out.println(res.size());
    }

    public List<List<Integer>> combinationSum(Integer[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        Arrays.sort(candidates);
        dfs(res, 0, target, path, candidates);
        return res;
    }

    public void dfs(List<List<Integer>> res, int begin, int target, List<Integer> path, Integer[] nums) {
        if (target == 0) {
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = begin; i < nums.length; i++) {
            if (nums[i] > target) {
                break;
            }
            path.add(nums[i]);
            dfs(res, i, target - nums[i], path, nums);
            path.remove(path.size() - 1);
        }
    }
}
