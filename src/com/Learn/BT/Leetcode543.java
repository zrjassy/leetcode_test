package com.Learn.BT;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p>最大直径</p>
 *
 * @author : 你的名字
 * @date : 2023-05-10 16:49
 **/
public class Leetcode543 {
    public static void main(String[] args) {

    }

    int maxDiametor = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        maxDepth(root);
        return maxDiametor;
    }

    public int maxDepth(TreeNode node) {
        if(node == null) {
            return 0;
        }
        int leftDepth = maxDepth(node.left);
        int rightDepth = maxDepth(node.right);
        maxDiametor = Math.max(maxDiametor, leftDepth+rightDepth);
        return 1+Math.max(leftDepth, rightDepth);
    }

    class TreeNode {
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
