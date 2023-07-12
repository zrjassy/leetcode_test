package com.Learn.Leetcode;

import java.util.Arrays;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p> 最接近的三数之和 </p>
 *
 * @author : 张锐
 * @date : 2023-06-04 15:11
 **/
public class Q16 {
    public static void main(String[] args) {
        int[] nums = {-1, 2, 1, -4};
        int target = 1;

        Q16 q16 = new Q16();
        System.out.println(q16.threeSumClosest(nums, target));
    }

    public int threeSumClosest(int[] nums, int target) {

    }

    public int twoSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        
    }
}
