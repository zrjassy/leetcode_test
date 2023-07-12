package com.HUAWEI.Q23_1;

import java.util.Scanner;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 你的名字
 * @date : 2023-05-19 22:08
 **/
public class Q91 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(search(s));
    }

    public static int search(String s) {
        if (s.equals("M")) return -1;
        if (s.equals("I")) return 0;

        int result = 0;
        char[] chars = s.toCharArray();
        if (chars[0] == 'M') {
            if (chars[1] == 'I') {
                chars[1] = 'X';
                result++;
            } else {
                return -1;
            }
        }

        if (chars[s.length() - 1] == 'M') {
            if (chars[s.length() - 2] == 'I') {
                chars[s.length() - 2] = 'X';
                result++;
            } else if (chars[s.length() - 2] == 'M') {
                return -1;
            }
        }

        for (int i = 1; i < s.length() - 1; i++) {
            if (chars[i] == 'M') {
                if (chars[i - 1] == 'X' || chars[i + 1] == 'X') continue;
                if (chars[i + 1] == 'I') {
                    chars[i + 1] = 'X';
                    result++;
                } else if (chars[i - 1] == 'I') {
                    chars[i - 1] = 'X';
                    result++;
                } else {
                    return -1;
                }
            }
        }
        return result;
    }
}
