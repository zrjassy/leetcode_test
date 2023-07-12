package com.HUAWEI.Q22_4;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 你的名字
 * @date : 2023-05-15 02:39
 **/
public class Q12 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int[] sToNum = new int[s.length()];
        // 将字符串转换成数字方便后续查找。
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case 'W' -> sToNum[i] = 0;
                case 'A' -> sToNum[i] = 1;
                case 'D' -> sToNum[i] = 2;
                case 'S' -> sToNum[i] = 3;
            }
        }

        // nums存储每个数字出现的次数
        int[] nums = new int[4];
        for (int i = 0; i < s.length(); i++) {
            int index = sToNum[i];
            nums[index]++;
        }
        int per = s.length() / 4;
        for (int i = 0; i < 4; i++) {
            if (nums[i] > per) {
                nums[i] = nums[i] - per;
            } else {
                nums[i] = 0;
            }
        }
        // needFix 表示需要更改的字母的个数，显然要替换的子串长度必须大于等于这个大小，
        int needFix = Arrays.stream(nums).sum();

        int minLen = s.length();
        int[] tempNums = new int[4];
        int l = 0, r = needFix;

        for (int i = l; i < r; i++) {
            int index = sToNum[i];
            tempNums[index]++;
        }

        while (r < s.length()) {
            while (check(tempNums, nums)) {
                minLen = Math.min(minLen, r - l);
                if (r - l == needFix) {
                    break;
                }
                tempNums[sToNum[l]]--;
                l++;
            }
            tempNums[sToNum[r]]++;
            r++;
        }

        System.out.println(minLen);
    }

    public static boolean check(int[] tempNums, int[] nums) {
        boolean flag = true;
        for (int i = 0; i < nums.length; i++) {
            if (tempNums[i] < nums[i]) {
                flag = false;
                break;
            }
        }
        return flag;
    }
}
