package com.Learn.SlidingWindow;

import java.util.HashMap;

public class Leetcode567 {
    public static void main(String[] args) {
        String s1 = "ab";
        String s2 = "eidbaooo";

        Leetcode567 leetcode567 = new Leetcode567();
        System.out.println(leetcode567.checkInclusion(s1, s2));
    }

    public boolean checkInclusion(String s1, String s2) {
        HashMap<Character, Integer> need = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();

        for (char ch : s1.toCharArray()) {
            need.put(ch,need.getOrDefault(ch, 0) + 1);
        }

        return true;
    }

}
