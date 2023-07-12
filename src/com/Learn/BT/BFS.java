package com.Learn.BT;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p>广度遍历</p>
 *
 * @author : 你的名字
 * @date : 2023-05-10 16:51
 **/
public class BFS {
    public static void main(String[] args) {

    }

    void levelTraverse(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        LinkedList<TreeNode> nodes = new LinkedList<>();
        q.offer(root);
        nodes.add(root);

        while (!q.isEmpty()) {
            int size = q.size();

            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (cur.left!=null) {
                    q.offer(cur.left);
                    nodes.add(cur.left);
                }
                if (cur.right!=null) {
                    q.offer(cur.right);
                    nodes.add(cur.right);
                }
            }
        }
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
