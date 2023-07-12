package com.HUAWEI.Q22_4;

// https://blog.csdn.net/misayaaaaa/article/details/127947805

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Q1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        task[] tasks = new task[n];
        for (int i = 0; i < n; i++) {
            int begin = sc.nextInt();
            int end = sc.nextInt();
            int weight = sc.nextInt();
            tasks[i] = new task(begin, end, weight);
        }
        Arrays.sort(tasks, Comparator.comparingInt(o -> o.begin));
        PriorityQueue<task> pq = new PriorityQueue<>(
                n, Comparator.comparingInt(a -> a.end)
        );

        int max = 0;
        int temp = 0;
        for (task t : tasks) {
            // 当一个新任务出现时，将其与优先级队列的头部进行比较
            // 若新任务的开始时间大于等于头部任务的结束时间，说明头部任务已经结束，删去该任务以及其权重
            while (pq.size() > 0) {
                task top = pq.peek();
                if (t.begin >= top.end) {
                    pq.poll();
                    temp -= top.weight;
                } else {
                    break;
                }
            }
            pq.offer(t);
            temp += t.weight;
            if (temp > max) {
                max = temp;
            }
        }
        System.out.println(max);
    }

    public static class task {
        int begin;
        int end;
        int weight;

        public task() {
        }

        public task(int begin, int end, int weight) {
            this.begin = begin;
            this.end = end;
            this.weight = weight;
        }
    }
}
