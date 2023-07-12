package com.Learn.JavaLearn;

import java.sql.Time;
import java.util.Timer;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 你的名字
 * @date : 2023-05-17 02:52
 **/
public class CalculateJava {
    public static void main(String[] args) {
        CalculateJava calculateJava = new CalculateJava();
        calculateJava.start();

        try {
            int[] ints = new int[1000];
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        calculateJava.end();

        calculateJava.PrintResult();
    }

    Runtime r = Runtime.getRuntime();
    long startTime, startMem;
    long endTime, endMem;

    public CalculateJava() {
        r.gc();//计算内存前先垃圾回收一次
    }

    public void start() {
        startTime = System.currentTimeMillis();
        startMem = r.totalMemory(); // 开始Memory
    }

    public void end() {
        endTime = System.currentTimeMillis();
        endMem = r.freeMemory(); // 末尾Memory
    }

    public void PrintResult() {
        System.out.println("用时消耗: " + String.valueOf(endTime - startTime) + "ms");
        System.out.println("内存消耗: " + String.valueOf((startMem - endMem) / 1024) + "KB");
    }

}
