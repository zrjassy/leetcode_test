package com.HUAWEI.HandWrite;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p><a href="https://blog.csdn.net/LINZEYU666/article/details/123706746?spm=1001.2014.3001.5502">...</a></p>
 *
 * @author : 张锐
 * @date : 2023-05-23 10:48
 **/
public class Q1056 {
    public static void main(String[] args) {
        int[] nums = {3, 3, 7, 7, 10, 11, 11};
        System.out.println(find(nums));
    }

    public static int find(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == nums[mid ^ 1]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return nums[left];
    }

}
