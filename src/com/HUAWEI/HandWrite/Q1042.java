package com.HUAWEI.HandWrite;

import java.util.HashSet;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 张锐
 * @date : 2023-05-30 18:39
 **/
public class Q1042 {
    public static void main(String[] args) {
        int[] nums = {3, 10, 5, 25, 2, 8};
        System.out.println(findMaxXor(nums));
    }

    public static int findMaxXor(int[] nums) {
        int x = 0;
        for (int k = 30; k >= 0; k--) {
            HashSet<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num >> k);
            }

            int x_next = 2 * x + 1;
            boolean flag = false;

            for (int num : nums) {
                if (set.contains(x_next ^ (num >> k))) {
                    flag = true;
                    break;
                }
            }
            if (!flag) {
                x = x_next - 1;
            } else {
                x = x_next;
            }
        }
        return x;
    }
}
