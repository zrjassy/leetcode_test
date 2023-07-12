package com.HUAWEI.HandWrite;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 张锐
 * @date : 2023-06-02 01:52
 **/
public class Q1057 {
    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        randomizedSet.insert(10);
        randomizedSet.insert(5);
        randomizedSet.insert(3);
        randomizedSet.insert(4);
        randomizedSet.insert(7);
        System.out.println(randomizedSet.getRandom());
        randomizedSet.remove(10);
        System.out.println(randomizedSet.getRandom());
    }

    static class RandomizedSet {

        private List<Integer> nums = new LinkedList<>();
        private HashMap<Integer, Integer> hashMap = new HashMap<>();

        public boolean insert(int x) {
            if (hashMap.containsKey(x)) {
                return false;
            }
            nums.add(x);
            hashMap.put(x, nums.size() - 1);
            return true;
        }

        public boolean remove(int x) {
            if (!hashMap.containsKey(x)) {
                return false;
            }

            int last = nums.get(nums.size() - 1);
            int index = hashMap.get(x);
            hashMap.remove(x);
            hashMap.put(last, index);
            nums.remove(nums.size() - 1);
            nums.set(index, last);
            return true;
        }

        public int getRandom() {
            int size = nums.size();
            int x = new Random().nextInt(size);
            return nums.get(x);
        }
    }
}
