package com.HUAWEI.Q23_1;

import java.util.HashMap;
import java.util.Scanner;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 你的名字
 * @date : 2023-05-19 15:06
 **/
public class Q85 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String word = sc.nextLine();

        int ans = find(s, word);
        System.out.println(ans);
    }

    public static int find(String s, String word) {
        HashMap<Character, Integer> wordMap = new HashMap<>();
        HashMap<Character, Integer> windowMap = new HashMap<>();
        for (Character ch : word.toCharArray()) {
            wordMap.put(ch, wordMap.getOrDefault(ch, 0) + 1);
        }
        int result = 0;
        int N = wordMap.size();
        int len = word.length();
        int window_N = 0;
        if (s.length() < len) return 0;

        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            windowMap.put(ch, windowMap.getOrDefault(ch, 0) + 1);
            if (wordMap.containsKey(ch) && wordMap.get(ch).equals(windowMap.get(ch))) {
                window_N++;
            }
        }
        if (window_N == N) result++;
        if (s.length() == len) return result;
        for (int i = len; i < s.length(); i++) {
            char leftCh = s.charAt(i - len);
            char rightCh = s.charAt(i);
            windowMap.put(leftCh, windowMap.get(leftCh) - 1);
            windowMap.put(rightCh, windowMap.getOrDefault(rightCh, 0) + 1);
            if (wordMap.containsKey(leftCh)) {
                window_N--;
            }
            if (wordMap.containsKey(rightCh) && wordMap.get(rightCh).equals(windowMap.get(rightCh))) {
                window_N++;
            }
            if (window_N == N) result++;
        }
        return result;
    }
}
