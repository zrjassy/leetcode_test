package com.HUAWEI.Q22_4;

import java.util.HashMap;
import java.util.Scanner;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p>通信误码</p>
 *
 * @author : 张锐
 * @date : 2023-05-09 20:28
 **/
public class Q58 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            int n = sc.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = sc.nextInt();
            }

            HashMap<Integer, Integer[]> map = new HashMap<>();
            for (int i = 0; i < n; i++) {
                if (map.containsKey(nums[i])) {
                    Integer[] temp = map.get(nums[i]);
                    temp[0]++;
                    temp[2] = i;
                    map.put(nums[i], temp);
                } else {
                    Integer[] temp = {1, i, i};
                    map.put(nums[i], temp);
                }
            }

            int minResult = n;
            int num = 0;
            for (Integer[] temp : map.values()) {
                if (temp[0]>=num) {
                    num = temp[0];
                    minResult = Math.min(minResult, temp[2]- temp[1] + 1);
                }
            }
            System.out.println(minResult);
        }
    }
}
