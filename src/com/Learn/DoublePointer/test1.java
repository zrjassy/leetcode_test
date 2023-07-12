package com.Learn.DoublePointer;

import java.util.*;

public class test1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;

        ListNode dummy = new ListNode(-1), p = dummy;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
                lists.length, Comparator.comparingInt(a -> a.val));
        for (ListNode tempHead:lists) {
            if (tempHead!=null) {
                pq.offer(tempHead);
            }
        }

        while (!pq.isEmpty()) {
            ListNode temp = pq.poll();
            p.next = temp;
            if (temp.next!=null) {
                pq.offer(temp.next);
            }
            p = p.next;
        }
        return dummy.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
