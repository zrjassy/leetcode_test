package com.HUAWEI.Q23_1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 你的名字
 * @date : 2023-05-16 16:24
 **/
public class Q130 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int n = sc.nextInt();
        sc.nextLine();
        List<Integer> list = Arrays.stream(sc.nextLine().split(",")).map(Integer::parseInt).toList();
        int result = 0;
        ArrayList<Integer> list1 = new ArrayList<>();
        boolean flag = false;
        for (Integer integer : list) {
            if (integer < 0) {
                list1.add(integer);
                flag = true;
            }
            if (integer >= 0 && flag) {
                result += find(list1, len);
                list1.clear();
                flag = false;
            }
        }
        System.out.println(result);
    }

    public static int find(ArrayList<Integer> list, int len) {
        if (list.size() < len) return 0;
        int result = list.size() / len;
        for (int i = 0; i < list.size(); i++) {
            list.set(i, list.get(i) + 1);
        }
        ArrayList<Integer> list2 = new ArrayList<>();
        boolean flag = false;
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) < 0) {
                list2.add(list.get(i));
                flag = true;
            }
            if ((i == list.size() - 1 || list.get(i) >= 0) && flag ) {
                result += find(list2, len);
                list2.clear();
                flag = false;
            }
        }

        return result;
    }
}
