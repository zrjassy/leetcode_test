package com.Learn.SlidingWindow;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p>单调队列</p>
 *
 * @author : 张锐
 * @date : 2023-05-31 01:02
 **/
public class MonotonixQueue {
    public static void main(String[] args) {
        MonotonixQueue monotonixQueue = new MonotonixQueue();
        int[] nums = {1, 3, -1, -3, 5};
        int k = 3;

        List<Integer> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (i < k - 1) {
                monotonixQueue.push(nums[i]);
            } else {
                monotonixQueue.push(nums[i]);
                res.add(monotonixQueue.max());
                monotonixQueue.pop(nums[i - k + 1]);
            }
        }
        System.out.println(res);
    }

    LinkedList<Integer> queue = new LinkedList<>();

    public void push(int n) {
        while (!queue.isEmpty() && queue.getLast() < n) {
            queue.pollLast();
        }
        queue.addLast(n);
    }

    public void pop(int n) {
        if (n == queue.getFirst()) {
            queue.pollFirst();
        }
    }

    public int max() {
        return queue.getFirst();
    }
}
