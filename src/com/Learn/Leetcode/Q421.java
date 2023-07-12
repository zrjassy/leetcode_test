package com.Learn.Leetcode;

import com.Learn.BT.TreeNode;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p>字典树</p>
 *
 * @author : 张锐
 * @date : 2023-05-26 09:58
 **/
public class Q421 {
    public static void main(String[] args) {
        int[] nums = {3, 10, 5, 25, 2, 8};
        System.out.println(findMaximumXOR(nums));
    }

    public static int findMaximumXOR(int[] nums) {
        Trie trie = new Trie();
        if (nums.length < 2) return 0;
        int res = 0;
        for (int num : nums) {
            trie.insert(num);
            res = Math.max(res, trie.findMax(num));
        }
        return res;
    }

    static class Trie {
        Trie[] children;
        boolean isEnd;

        public Trie() {
            children = new Trie[2];
            isEnd = false;
        }

        public void insert(int num) {
            Trie node = this;
            for (int i = 30; i >= 0; i--) {
                int index = (num >> i) & 1;
                if (node.children[index] == null) {
                    node.children[index] = new Trie();
                }
                node = node.children[index];
            }
            node.isEnd = true;
        }

        public int findMax(int num) {
            Trie node = this;
            int max = 0;

            for (int i = 30; i >= 0; i--) {
                // num的第i位为index，则找一下1-index是否存在，存在就走1-index，否则只能走另一个。
                int index = (num >> i) & 1;
                index ^= 1;
                if (node.children[index] != null) {
                    max |= 1 << i;
                } else {
                    index ^= 1;
                }
                node = node.children[index];
            }
            return max;
        }
    }
}
