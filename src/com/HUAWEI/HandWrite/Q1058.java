package com.HUAWEI.HandWrite;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 张锐
 * @date : 2023-06-01 12:55
 **/
public class Q1058 {
    public static void main(String[] args) {
        int[] nums = {1, 3, 1, 4, 2};
        int target = 5;

        Q1058 q1055 = new Q1058();
        System.out.println(q1055.findTargetSumWays(nums, target));
    }

    public int findTargetSumWays(int[] nums, int target) {
        if (nums.length == 0) return 0;
        return dfs(nums, 0, target);
    }

    public int dfs(int[] nums, int index, int target) {
        int result = 0;

        if (index == nums.length) {
            if (target == 0)
                result++;
            return result;
        }

        target += nums[index];
        result += dfs(nums, index + 1, target);
        target -= nums[index];

        target -= nums[index];
        result += dfs(nums, index + 1, target);
        target += nums[index];

        return result;
    }
}
