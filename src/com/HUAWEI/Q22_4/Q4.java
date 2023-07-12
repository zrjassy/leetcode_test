package com.HUAWEI.Q22_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 你的名字
 * @date : 2023-05-11 02:27
 **/
public class Q4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        int N = sc.nextInt();

        ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
        for (int i = 0; i <= M; i++) {
            lists.add(new ArrayList<>());
        }
        for (int i = 0; i < N; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();
            lists.get(v1).add(v2);
            lists.get(v2).add(v1);
        }

        int[] nums = new int[M + 1];
        Arrays.fill(nums, -1);
        DFS(nums, lists, 1);
        System.out.println(result);
    }

    static int result = 0;

    public static void DFS(int[] nums, ArrayList<ArrayList<Integer>> lists, int index) {
        if (index == nums.length - 1) {
            result = result + 2;
            for (int i = 0; i < lists.get(index).size(); i++) {
                int index_connect = lists.get(index).get(i);
                if (nums[index_connect] == 1) {
                    result--;
                    break;
                }
            }
            return;
        }

        for (int i = 0; i < 2; i++) {
            nums[index] = i;

            int flag = 0;
            for (int j = 0; j < lists.get(index).size(); j++) {
                int index_connect = lists.get(index).get(j);
                if (nums[index_connect] == 1) {
                    flag = 1;
                    break;
                }
            }
            if (i == 1 && flag == 1) {
                continue;
            }
            nums[index] = i;
            DFS(nums, lists, index + 1);
            nums[index] = -1;
        }
    }
}
