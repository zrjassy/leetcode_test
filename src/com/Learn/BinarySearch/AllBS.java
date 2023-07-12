package com.Learn.BinarySearch;

import java.util.Arrays;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p>三种二分搜索方式</p>
 *
 * @author : 张锐
 * @date : 2023-05-09 01:56
 **/
public class AllBS {
    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 5, 5, 8, 9, 12};
        int[] nums1 = {1, 2, 3, 5, 6, 8, 9, 12};
        int target = 5;
        AllBS allBS = new AllBS();
        System.out.println(allBS.binarySearch(nums1, target));
        System.out.println(allBS.left_bound(nums, target));
        System.out.println(allBS.right_bound(nums, target));
    }

    public int binarySearch(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid - 1;
            }
        }
        return -1;
    }

    public int left_bound(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        if (left == nums.length) return -1;
        return nums[left] == target ? left : -1;
    }

    public int right_bound(int[] nums, int target) {
        Arrays.sort(nums);
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        if (left == nums.length) return -1;
        if (left == 0 && nums[0] == target) return left;
        return nums[left - 1] == target ? left - 1 : -1;
    }
}
