package com.HUAWEI.HandWrite;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 张锐
 * @date : 2023-05-30 17:46
 **/
public class Q1046 {
    public static void main(String[] args) {
        String[] timePoints = new String[]{"23:59", "00:00", "00:00"};

        System.out.println(findMinDivide(timePoints));
    }

    public static int findMinDivide(String[] timePoints) {
        if (timePoints.length > 24 * 60) return 0;

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < timePoints.length; i++) {
            String[] time = timePoints[i].split(":");
            int temp = 60 * Integer.parseInt(time[0]) + Integer.parseInt(time[1]);
            list.add(temp);
        }
        Collections.sort(list);
        list.add(list.get(0) + 24 * 60);
        int min = 24 * 60;
        for (int i = 0; i < list.size() - 1; i++) {
            min = Math.min(min, list.get(i + 1) - list.get(i));
        }
        return min;
    }
}
