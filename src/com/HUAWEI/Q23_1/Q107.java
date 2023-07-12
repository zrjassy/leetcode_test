package com.HUAWEI.Q23_1;

import java.util.*;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 你的名字
 * @date : 2023-05-20 02:07
 **/
public class Q107 {
    public static void main(String[] args) {
        int[] jobs = {1, 2, 3, 5, 6};
        int k = 3;
        System.out.println(minimumTimeRequired(jobs, k));
    }

    public static int minimumTimeRequired(int[] jobs, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < jobs.length; i++) {
            list.add(jobs[i]);
        }
        list.sort(Comparator.reverseOrder());
        System.out.println(list);
        return 0;
    }
}
