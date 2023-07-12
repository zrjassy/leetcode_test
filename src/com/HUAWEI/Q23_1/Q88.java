package com.HUAWEI.Q23_1;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 你的名字
 * @date : 2023-05-19 16:46
 **/
public class Q88 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '}') {
                StringBuffer buffer = new StringBuffer();
                while (!stack.peek().equals("{")) {
                    buffer.insert(0, stack.pop());
                }
                stack.pop();
                stack.push(buffer.toString());
            } else if (Character.isDigit(ch)) {
                int times = ch - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    times = 10 * times + s.charAt(i + 1);
                    i++;
                }
//                String temp = repeat(stack.pop(), times);
                String temp = stack.pop().repeat(times);
                stack.push(temp);
            } else {
                stack.push(String.valueOf(ch));
            }
        }

        StringBuffer stringBuffer = new StringBuffer();
        while (!stack.isEmpty()) {
            stringBuffer.insert(0, stack.pop());
        }
        System.out.println(stringBuffer);
    }

    public static String repeat(String s, int times) {
        StringBuffer buffer = new StringBuffer();
        for (int i = 0; i < times; i++) {
            buffer.append(s);
        }
        return buffer.toString();
    }
}
