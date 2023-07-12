package com.HUAWEI.Q23_1;

import java.util.Map;
import java.util.Scanner;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 你的名字
 * @date : 2023-05-20 00:19
 **/
public class Q97 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        int result = s.length();

        int LeftB = 0;
        int RightA = 0;
        for (char ch : s.toCharArray()) {
            if (ch == 'A') RightA++;
        }
        for (char ch : s.toCharArray()) {
            if (ch == 'A') {
                RightA--;

            }else if (ch == 'B') {
                LeftB++;
            }
            result = Math.min(result , RightA + LeftB);
        }
        System.out.println(result);
    }
}
