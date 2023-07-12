package com.HUAWEI.HandWrite;

import java.util.HashMap;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 张锐
 * @date : 2023-06-01 14:09
 **/
public class Q1036 {
    public static void main(String[] args) {

    }

    public int findMaxLength(int[] nums) {
        int maxLength = 0;

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        hashMap.put(0, -1);

        int preSum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                preSum++;
            } else {
                preSum--;
            }

            if (hashMap.containsKey(preSum)) {
                maxLength = Math.max(maxLength, i - hashMap.get(preSum));
            } else {
                hashMap.put(preSum, i);
            }
        }
        return maxLength;
    }
}
