package com.Learn.JavaLearn;

import com.Learn.BT.TreeNode;

import java.util.List;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 张锐
 * @date : 2023-05-26 08:56
 **/
public class test5 {
    public static void main(String[] args) {
        int[] nums = {1, 4, 6, 2, 6};
        ListNode root = buildList(nums);
        printList(root);
        ListNode reverseRoot = reverse(root);
        printList(reverseRoot);
    }

    public static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode last = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return last;
    }

    public static ListNode buildList(int[] nums) {
        if (nums.length == 0) return null;

        ListNode head = new ListNode(-1);
        ListNode p = head;

        for (int i = 0; i < nums.length; i++) {
            p.next = new ListNode(nums[i]);
            p = p.next;
        }
        return head.next;
    }

    public static void printList(ListNode root) {
        while (root != null) {
            System.out.println(root.val);
            root = root.next;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        public ListNode(int x) {
            val = x;
        }
    }
}
