package com.HUAWEI.HandWrite;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 张锐
 * @date : 2023-05-23 02:09
 **/
public class Q1 {
    public static void main(String[] args) {
        int[] nums = {1, 4, 3, 2, 5};
        int x = 3;
        Node head = build(nums);
        printList(head);
        Node newHead = divideByX(head, x);
        printList(newHead);
    }

    public static Node divideByX(Node root, int x) {
        Node headMin = new Node(-1);
        Node headMax = new Node(-1);

        Node p1 = headMin, p2 = headMax;

        Node temp = root.next;
        while (temp != null) {
            if (temp.val < x) {
                p1.next = temp;
                p1 = p1.next;
            } else {
                p2.next = temp;
                p2 = p2.next;
            }
            temp = temp.next;
        }
        p1.next = headMax.next;

        return headMin;
    }

    public static void printList(Node root) {
        root = root.next;
        while (root != null) {
            System.out.println(root.val);
            root = root.next;
        }
    }

    public static Node build(int[] nums) {
        Node head = new Node(-1);
        Node node = new Node(nums[0]);
        head.next = node;
        Node p = head.next;
        for (int i = 1; i < nums.length; i++) {
            Node temp = new Node(nums[i]);
            p.next = temp;
            p = p.next;
        }
        p.next = null;
        return head;
    }

    static class Node {
        int val;
        Node next;

        public Node(int val) {
            this.val = val;
            this.next = null;
        }
    }
}
