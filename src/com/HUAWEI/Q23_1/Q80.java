package com.HUAWEI.Q23_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/* Q79 组装新的数组
 * 题目描述
 * 给你一个整数M和数组N, N中的元素为连续整数，要求根据N中的元素组装成新的数组R，组装规则:
 * 1.R中元素总和加起来等于M
 * 2.R中的元素可以从N中重复选取
 * 3.R中的元素最多只能有1个不在N中，且比N中的数字都要小(不能为负数)
 * 输入描述
 * 第一行输入是连续数组N，采用空格分隔
 * 第二行输入数字M
 * 输出描述
 * 输出的是组装办法数量，int类型
 *
 * 备注
 * 1 ≤ M ≤ 30
 * 1≤ N.length ≤ 1000
 * 示例1
 * 输入
 * 2
 * 5
 * 输出
 * 1
 * 说明
 * 只有1种组装办法，就是[2,2,1]
 * 示例2
 * 输入
 * 2 3
 * 5
 * 输出
 * 2
 * 说明
 * 共两种组装办法，分别是[2,2,1]， [2,3]
 * */
public class Q80 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Integer[] N = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toArray(Integer[]::new);
        int M = sc.nextInt();
        List<List<Integer>> res = Solution1(N, M);
        System.out.println(res);
    }

    public static List<List<Integer>> Solution1(Integer[] N, int m) {
        Arrays.sort(N);
        int Min_N = N[0];
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
//        dfs(res, 0, m, 0, path, N, Min_N);
        dfs2(res, 0, m, path, N, Min_N);
        return res;
    }

    private static void dfs(List<List<Integer>> res, int idx, int target, int sum, List<Integer> path, Integer[] nums, int Min_N) {
//        System.out.println(sum);
        if (sum > target - Min_N && sum <= target) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            if (sum + nums[i] > target) break;
            path.add(nums[i]);
            sum += nums[i];
            dfs(res, i, target, sum, path, nums, Min_N);
            path.remove(path.size() - 1);
            sum -= nums[i];
        }
    }

    private static void dfs2(List<List<Integer>> res, int idx, int target, List<Integer> path, Integer[] nums, int Min_N) {
//        System.out.println(sum);
        if (target < Min_N && target >= 0) {
            res.add(new ArrayList<>(path));
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            if (target < nums[i]) break;
            path.add(nums[i]);
            target -= nums[i];
            dfs2(res, i, target, path, nums, Min_N);
            path.remove(path.size() - 1);
            target += nums[i];
        }
    }
}
