package com.HUAWEI.HandWrite;

import java.util.ArrayList;
import java.util.List;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 张锐
 * @date : 2023-05-30 18:03
 **/
public class Q1045 {
    public static void main(String[] args) {
        int[] nums = {-2};

        System.out.println(attack(nums));
    }

    public static List<Integer> attack(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                list.add(nums[i]);
            } else {
                boolean flag = false;
                int temp = list.get(list.size() - 1);
                if (temp < 0) list.add(nums[i]);
                else {
                    while (temp > 0) {
                        if ((-1) * nums[i] > temp) {
                            list.remove((Integer) temp);
                            temp = list.get(list.size() - 1);
                        } else {
                            flag = true;
                            break;
                        }
                    }
                    if (!flag) {
                        list.add(nums[i]);
                    }
                }
            }
        }
        return list;
    }
}
