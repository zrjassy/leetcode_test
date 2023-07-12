package com.Learn.BT;

// leetcode124  https://leetcode.cn/problems/binary-tree-maximum-path-sum/description/
public class test1 {
    public static void main(String[] args) {
        // root = [-10,9,20,null,null,15,7]
        TreeNode root = new TreeNode(-10);
        TreeNode node1 = new TreeNode(9, null, null);
        TreeNode node2 = new TreeNode(15);
        TreeNode node3 = new TreeNode(7);
        TreeNode node4 = new TreeNode(20, node2, node3);
        root.left = node1;
        root.right = node4;

        test1 test1 = new test1();
        System.out.println(test1.maxPathSum(root));
    }

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    public int maxGain(TreeNode node) {
        if (node == null) return 0;

        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        int pricePath = node.val + leftGain + rightGain;
        maxSum = Math.max(pricePath, maxSum);
        return node.val + Math.max(leftGain, rightGain);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
