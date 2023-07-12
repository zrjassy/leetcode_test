package com.Learn.BT;

// 二叉树的深度
public class Leetcode104 {
    public static void main(String[] args) {

    }

    int maxDepth = 0;
    int depth = 0;
    public int maxDepth(TreeNode root) {
        traverse(root);
        return maxDepth;
    }

    public void traverse(TreeNode node) {
        if (node == null) return;
        depth++;
        if (node.left == null && node.right == null) {
            maxDepth = Math.max(maxDepth, depth);
            return;
        }
        traverse(node.left);
        traverse(node.right);
        depth--;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
