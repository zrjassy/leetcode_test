package com.Learn.Leetcode;

import com.HUAWEI.Q22_4.Q17;

import java.util.Arrays;
import java.util.Comparator;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 张锐
 * @date : 2023-05-31 00:07
 **/
public class Q1723 {
    public static void main(String[] args) {
        int[] jobs = {1, 2, 4, 7, 8};
        int k = 2;

        Q1723 ques = new Q1723();
        System.out.println(ques.minimumTimeRequired(jobs, k));
    }

    public int minimumTimeRequired(int[] jobs, int k) {
        Integer[] integers = Arrays.stream(jobs).boxed().toArray(Integer[]::new);
        Arrays.sort(integers, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        int left = jobs[0];
        int right = Arrays.stream(jobs).sum();

        while (left < right) {
            int middle = left + (right - left) / 2;

            if (check(integers, k, middle)) {
                right = middle;
            } else {
                left = middle + 1;
            }
        }
        return left;
    }

    public boolean check(Integer[] jobs, int k, int limit) {
        int[] works = new int[k];
        return backtrack(jobs, 0, limit, works);
    }

    public boolean backtrack(Integer[] jobs, int index, int limit, int[] works) {
        if (index == jobs.length) return true;

        int cur = jobs[index];

        for (int i = 0; i < works.length; i++) {
            if (works[i] + cur <= limit) {
                works[i] += cur;
                if (backtrack(jobs, index + 1, limit, works)) {
                    return true;
                }
                works[i] -= cur;
            }
            // 如果当前未被分配工作，则不用继续考虑下一个工人了
            if (works[i] == 0) {
                break;
            }
        }
        return false;
    }
}
