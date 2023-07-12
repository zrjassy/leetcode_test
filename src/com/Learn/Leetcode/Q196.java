package com.Learn.Leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 张锐
 * @date : 2023-05-31 00:46
 **/
public class Q196 {
    public static void main(String[] args) {

    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int[] res = new int[n];

        HashMap<Integer, Integer> map = new HashMap<>();
        int[] resWithNum2 = nextGreaterElement(nums2);
        for (int i = 0; i < resWithNum2.length; i++) {
            map.put(nums2[i], resWithNum2[i]);
        }

        for (int i = 0; i < n; i++) {
            res[i] = map.get(nums1[i]);
        }
        return res;
    }

    public int[] nextGreaterElement(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            res[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(nums[i]);
        }
        return res;
    }
}
