package com.Learn.SlidingWindow;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p><a href="https://leetcode.cn/problems/repeated-dna-sequences/">...</a></p>
 *
 * @author : 张锐
 * @date : 2023-05-07 07:26
 **/
public class Leetcode187 {
    public static void main(String[] args) {
        String s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";

        Leetcode187 lc = new Leetcode187();
        System.out.println(lc.findRepeatedDnaSequences(s));
    }

    public List<String> findRepeatedDnaSequences(String s) {
        int[] nums = new int[s.length()];
        for (int i = 0; i < nums.length; i++) {
            switch (s.charAt(i)) {
                case 'A' -> nums[i] = 1;
                case 'C' -> nums[i] = 2;
                case 'G' -> nums[i] = 3;
                case 'T' -> nums[i] = 4;
            }
        }

        int L = 10;
        int R = 4;
        int RL = (int) Math.pow(R, L - 1);
        int WindowHash = 0;

        HashSet<String> res = new HashSet<>();
        HashSet<Integer> hashSet = new HashSet<>();

        int left = 0, right = 0;
        while (right < nums.length) {
            WindowHash = R * WindowHash + nums[right];
            right++;

            if (right - left == L) {
                if (hashSet.contains(WindowHash)) {
                    res.add(s.substring(left, right));
                } else {
                    hashSet.add(WindowHash);
                }

                WindowHash = WindowHash - nums[left] * RL;
                left++;
            }
        }

        return new LinkedList<>(res);
    }
}
