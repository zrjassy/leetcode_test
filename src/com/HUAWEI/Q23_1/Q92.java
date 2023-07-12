package com.HUAWEI.Q23_1;

import java.util.*;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 你的名字
 * @date : 2023-05-19 22:38
 **/
public class Q92 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int M = sc.nextInt();
        sc.nextLine();
        List<Integer> list = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toList();
        List<Integer> fileSize = Arrays.stream(sc.nextLine().split(" ")).map(Integer::parseInt).toList();

        int[][] nums = new int[1001][2];
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < list.size(); i++) {
            set.add(list.get(i));
            nums[list.get(i)][0] = fileSize.get(i);
            nums[list.get(i)][1]++;
        }
        int result = 0;
        for (Integer x:set) {
            result = result + Math.min(M + nums[x][0], nums[x][0] * nums[x][1]);
        }
        System.out.println(result);
    }
}
