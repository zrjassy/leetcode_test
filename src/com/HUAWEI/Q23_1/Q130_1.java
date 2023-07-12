package com.HUAWEI.Q23_1;

import java.awt.*;
import java.util.*;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 你的名字
 * @date : 2023-05-16 17:03
 **/
public class Q130_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int N = sc.nextInt();
        sc.nextLine();
        Integer[] array = Arrays.stream(sc.nextLine().split(",")).map(Integer::parseInt).toArray(Integer[]::new);
        int[] nums = new int[N + 2];
        nums[0] = 0;
        nums[N + 1] = 0;
        for (int i = 1; i <= N; i++) {
            nums[i] = array[i - 1];
        }

        int result = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < N + 2; i++) {
            int tempLen = 0;
            int tempDepth = 0;
            while (!stack.isEmpty() && nums[stack.peek()] < 0 && nums[i] >= nums[stack.peek()]) {
                int index = stack.pop();
                tempLen++;
                tempDepth = nums[index];
                if (nums[stack.peek()] != tempDepth) {
                    result += tempLen / len  * (nums[stack.peek()] - tempDepth);
                }
            }
            stack.push(i);
        }
        System.out.println(result);
    }
}
