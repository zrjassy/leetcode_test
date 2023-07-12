package com.HUAWEI.Q22_4;

import java.lang.reflect.Array;
import java.util.*;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 你的名字
 * @date : 2023-05-16 18:06
 **/
public class Q52 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s1 = sc.nextLine();
        String s2 = sc.nextLine();

        HashMap<String, Integer> s1_sort = String_sort(s1);
        HashMap<String, Integer> s2_sort = String_sort(s2);
        boolean flag = true;
        for (String temp : s2_sort.keySet()) {
            if (!s1_sort.containsKey(temp) || s2_sort.get(temp) > s1_sort.get(temp)) {
                flag = false;
                break;
            }
        }
        System.out.println(flag);
    }

    public static HashMap<String, Integer> String_sort(String s) {
        String[] str = s.split(" ");
        HashMap<String, Integer> map = new HashMap<>();
        for (String temp : str) {
            char[] a = temp.toCharArray();
            Arrays.sort(a);
            String b = Arrays.toString(a);
            map.put(b, map.getOrDefault(b, 0) + 1);
        }
        return map;
    }
}
