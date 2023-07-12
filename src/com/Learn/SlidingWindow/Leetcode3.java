package com.Learn.SlidingWindow;

import java.util.HashMap;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 张锐
 * @date : 2023-06-01 14:00
 **/
public class Leetcode3 {
    public static void main(String[] args) {

    }

    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) return 0;

        HashMap<Character, Integer> hashMap = new HashMap<>();
        int max = 0;
        int left = 0;
        for (int right = 0; right < s.length(); right++) {
            if (hashMap.containsKey(s.charAt(right))) {
                left = Math.max(left, hashMap.get(s.charAt(right)) + 1);
            }
            hashMap.put(s.charAt(right), right);
            max = Math.max(max, right - left + 1);
        }
        return max;
    }
}
