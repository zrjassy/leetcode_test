package com.Learn.DoublePointer;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 你的名字
 * @date : 2023-05-20 22:06
 **/
public class Leetcode26 {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 4, 4, 6}; // 输入数组
        int[] expectedNums = {1, 2, 3, 4, 6}; // 长度正确的期望答案

        int k = removeDuplicates(nums); // 调用
        System.out.println(k);
        assert k == expectedNums.length;
        for (int i = 0; i < k; i++) {
            assert nums[i] == expectedNums[i];
        }
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int slow = 0, fast = 0;
        while (fast < nums.length) {
            if (nums[slow] != nums[fast]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
        }
        return slow + 1;
    }
}
