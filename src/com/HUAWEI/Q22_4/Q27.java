package com.HUAWEI.Q22_4;

import java.util.*;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 你的名字
 * @date : 2023-05-17 18:19
 **/
public class Q27 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        ArrayList<HashSet<Integer>> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            String[] str = sc.next().split(",");
            HashSet<Integer> set = new HashSet<>();
            for (String s : str) {
                set.add(Integer.parseInt(s));
            }
            list.add(set);
        }

        ArrayList<HashSet<Integer>> sets = new ArrayList<>();
        if (list.size() == 1) System.out.println(list);
        else {
            sets.add(list.get(0));
            for (int i = 1; i < list.size(); i++) {
                HashSet<Integer> temp = list.get(i);
                while (Merge(sets, temp)) ;
            }
        }
        System.out.println(sets);
    }

    public static boolean Merge(ArrayList<HashSet<Integer>> sets, HashSet<Integer> curSet) {
        for (int i = 0; i < sets.size(); i++) {
            HashSet<Integer> set = sets.get(i);
            int num = 0;
            for (Integer a : curSet) {
                if (set.contains(a)) {
                    num++;
                }
            }
            if (num >= 2) {
                set.addAll(curSet);
                sets.set(i, set);
                return true;
            }
        }
        sets.add(curSet);
        return false;
    }

}
