package com.HUAWEI.Q22_4;

import java.util.*;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 你的名字
 * @date : 2023-05-11 01:57
 **/
public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String[] str = s.split(" ");

        // 对每个单词进行字典排序
        ArrayList<String> strings = new ArrayList<>();
        for (String temp : str) {
            char[] chars = temp.toCharArray();
            Arrays.sort(chars);
            strings.add(String.valueOf(chars));
        }

        HashMap<String, Integer> map = new HashMap<>();
        for (String temp : strings) {
            if (map.containsKey(temp)) {
                map.put(temp, map.get(temp) + 1);
            } else {
                map.put(temp, 1);
            }
        }

        ArrayList<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((a, b) -> {
            if (a.getValue() > b.getValue()) return -1;
            else if (a.getValue() == b.getValue()) {
                if (a.getKey().length() > b.getKey().length()) {
                    return 1;
                } else if (a.getKey().length() == b.getKey().length()) {
                    return a.getKey().compareTo(b.getKey());
                } else {
                    return -1;
                }
            } else return 1;
        });

        String result = "";
        for (Map.Entry<String, Integer> temp : list) {
            for (int i = 0; i < temp.getValue(); i++) {
                result = result + temp.getKey() + " ";
            }
        }
        result = result.trim();
        System.out.println(result);
    }
}
