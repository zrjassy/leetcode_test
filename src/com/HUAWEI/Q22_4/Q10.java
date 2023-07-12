package com.HUAWEI.Q22_4;

import java.util.HashMap;
import java.util.Scanner;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 你的名字
 * @date : 2023-05-14 05:58
 **/
public class Q10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] strings = sc.nextLine().split(" ");
        HashMap<String, Integer> hashMap = new HashMap<>();
        // 0表示未检查，1表示检查为非潜在密码，2表示检查为潜在密码
        for (String s : strings) {
            hashMap.put(s, 0);
        }
        String truePassword = "";
        for (String s : strings) {
            if (search(hashMap, s) == 2) {
                if (s.length() > truePassword.length()) {
                    truePassword = s;
                }
                if (s.length() == truePassword.length() && s.compareTo(truePassword) > 0) {
                    truePassword = s;
                }
            }
        }
        System.out.println(truePassword);
    }

    public static int search(HashMap<String, Integer> hashMap, String s) {
        if (s.length() == 1) return 2;
        String temp = s.substring(0, s.length() - 1);
        if (!hashMap.containsKey(temp)) return 1;
        else if (hashMap.get(temp) == 0) {
            int ans = search(hashMap, temp);
            hashMap.put(temp, ans);
            return ans;
        } else {
            return hashMap.get(temp);
        }
    }
}
