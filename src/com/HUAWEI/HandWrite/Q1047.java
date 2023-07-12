package com.HUAWEI.HandWrite;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 张锐
 * @date : 2023-05-30 16:05
 **/
public class Q1047 {
    public static void main(String[] args) {
        String s = "00011000";
        System.out.println(reverseString(s));
        System.out.println(reverseStringByDp(s));
    }

    public static int reverseString(String s) {
        int left_1 = 0;
        int right_0 = 0;

        for (char ch : s.toCharArray()) {
            if (ch == '0') {
                right_0++;
            }
        }

        int min = right_0 + left_1;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                right_0--;
            } else {
                left_1++;
            }
            min = Math.min(min, left_1 + right_0);
        }
        return min;
    }

    public static int reverseStringByDp(String s) {
        int lastBy0 = 0;
        int lastBy1 = 0;
        if (s.charAt(0) == '0') {
            lastBy1 = 1;
        } else {
            lastBy0 = 1;
        }

        for (int i = 1; i < s.length(); i++) {
            int add0 = s.charAt(i) != '0' ? 1 : 0;
            lastBy0 = lastBy0 + add0;
            lastBy1 = Math.min(lastBy1, lastBy0) + (1 - add0);
        }
        return Math.min(lastBy1, lastBy0);
    }
}
