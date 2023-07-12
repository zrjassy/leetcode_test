package com.HUAWEI.Q22_4;

import java.util.*;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 你的名字
 * @date : 2023-05-16 23:08
 **/
public class Q19 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }
        // k-v 表示 数值k存在的距离，只有一个时为0，多个叠加。
        HashMap<Integer, List<Integer>> hashMap = new HashMap<>();
        int maxLength = -1;
        for (int i = 0; i < n; i++) {
            if (hashMap.containsKey(nums[i])) {
                List<Integer> list = hashMap.get(nums[i]);
                list.add(i);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(i);
                hashMap.put(nums[i], list);
            }
        }

        for (List<Integer> list : hashMap.values()) {
            if (list.size() > 1) {
                int len = list.get(list.size() - 1) - list.get(0);
                maxLength = Math.max(maxLength, len);
            }
        }
        System.out.println(maxLength);
    }
}
