package com.HUAWEI.Q22_4;

import java.util.*;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 你的名字
 * @date : 2023-05-16 18:38
 **/
public class Q76 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] nums = new int[N][M];
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                nums[i][j] = sc.nextInt();
                if (hashMap.containsKey(nums[i][j])) {
                    List<Integer> temp = hashMap.get(nums[i][j]);
                    temp.add(i);
                    temp.add(j);
                } else {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(i);
                    temp.add(j);
                    hashMap.put(nums[i][j], temp);
                }
            }
        }


        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                List<Integer> temp = hashMap.get(nums[i][j]);
                if (temp.size() == 2) nums[i][j] = -1;
                else {
                    int n = temp.size() / 2;
                    int min_distance = Integer.MAX_VALUE;
                    for (int k = 0; k < n; k++) {
                        int i0 = temp.get(2 * k);
                        int j0 = temp.get(2 * k + 1);
                        int d = Math.abs(i0 - i) + Math.abs(j0 - j);
                        if (d == 0) continue;
                        else {
                            min_distance = Math.min(min_distance, d);
                        }
                    }
                    nums[i][j] = min_distance;
                }
            }
        }

        System.out.println(Arrays.deepToString(nums).replaceAll(" ", ""));
    }
}
