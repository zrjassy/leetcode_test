package com.Learn.DoublePointer;

import com.Learn.SlidingWindow.Leetcode187;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p>优势排列（类田忌赛马问题）</p>
 *
 * @author : 张锐
 * @date : 2023-05-09 02:22
 **/
public class Leetcode870 {
    public static void main(String[] args) {
        int[] nums1 = {2, 0, 4, 1, 2};
        int[] nums2 = {1, 3, 0, 0, 2};

        Leetcode870 lc = new Leetcode870();
        System.out.println(Arrays.toString(lc.advantageCount(nums1, nums2)));
    }

    public int[] advantageCount(int[] nums1, int[] nums2) {
        int n = nums2.length;

        PriorityQueue<int[]> priorityQueue = new PriorityQueue<>(n, (int[] pair1, int[] pair2) -> {
            return pair2[1] - pair1[1];
        });
        for (int i = 0; i < n; i++) {
            priorityQueue.offer(new int[]{i, nums2[i]});
        }

        Arrays.sort(nums1);
        int[] res = new int[n];
        int left = 0, right = n - 1;

        while (!priorityQueue.isEmpty()) {
            int[] temp = priorityQueue.poll();
            int pos = temp[0], maxNums2 = temp[1];
            if (maxNums2 < nums1[right]) {
                res[pos] = nums1[right];
                right--;
            } else {
                res[pos] = nums1[left];
                left++;
            }
        }
        return res;
    }
}
