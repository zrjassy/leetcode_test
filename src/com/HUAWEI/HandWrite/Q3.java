package com.HUAWEI.HandWrite;

import java.util.Scanner;
import java.util.Stack;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 张锐
 * @date : 2023-05-23 02:47
 **/
public class Q3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(rollBack(s));
    }

    public static String rollBack(String s) {
        Stack<String> stack = new Stack<>();
        char[] chars = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            if (chars[i] == '(' || (chars[i] > 'a' && chars[i] < 'z')) {
                stack.push(String.valueOf(chars[i]));
            } else if (chars[i] == ')') {
                String temp = "";
                while (!stack.peek().equals("(")) {
                    StringBuilder sB = new StringBuilder(stack.pop());
                    String string = sB.reverse().toString();
                    temp = temp.concat(string);
                }
                stack.pop();
                stack.push(temp);
            }
        }
        StringBuilder sB = new StringBuilder();
        while (!stack.isEmpty()) {
            sB.insert(0, stack.pop());
        }
        return sB.toString();
    }
}
