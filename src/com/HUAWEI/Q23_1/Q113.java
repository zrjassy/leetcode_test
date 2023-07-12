package com.HUAWEI.Q23_1;

import java.util.*;
import java.util.stream.Collectors;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 你的名字
 * @date : 2023-05-20 01:23
 **/
public class Q113 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (Character ch : s.toCharArray()) {
            hashMap.put(ch, hashMap.getOrDefault(ch, 0) + 1);
        }

        ArrayList<Character> evenList = new ArrayList<>();
        ArrayList<Character> oddList = new ArrayList<>();

        for (Character ch : hashMap.keySet()) {
            int count = hashMap.get(ch);
            if (count >= 2) {
                for (int i = 0; i < count / 2; i++) {
                    evenList.add(ch);
                }
            }
            if (count % 2 != 0) {
                oddList.add(ch);
            }
        }

        evenList.sort(Comparator.comparingInt(a -> a));
        oddList.sort(Comparator.comparingInt(a -> a));
        String leftStr = "";
        String rightStr = "";
        String midStr = "";

        if (oddList.size() != 0) {
            midStr = midStr + oddList.get(0);
        }

        leftStr = evenList.stream().map(Object::toString).collect(Collectors.joining(""));
        evenList.sort((a, b) -> b - a);
        rightStr = evenList.stream().map(Object::toString).collect(Collectors.joining(""));
        System.out.println(leftStr+midStr+rightStr);
    }
}
