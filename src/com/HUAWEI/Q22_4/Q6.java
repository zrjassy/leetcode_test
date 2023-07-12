package com.HUAWEI.Q22_4;

import java.util.HashMap;
import java.util.Scanner;

/**
 * <h3>HUAWEI_EXAM</h3>
 * <p></p>
 *
 * @author : 你的名字
 * @date : 2023-05-11 16:27
 **/
public class Q6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] s = sc.nextLine().split(" ");
        String head_addr = s[0];
        int n = Integer.parseInt(s[1]);
        HashMap<String, ListNode> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] temp = sc.nextLine().split(" ");
            String addr = temp[0];
            int val = Integer.parseInt(temp[1]);
            ListNode node = new ListNode(val, temp[2]);
            hashMap.put(addr, node);
        }

        ListNode slow = hashMap.get(head_addr);
        ListNode fast = hashMap.get(head_addr);

        while (!fast.next.equals("-1")) {
            slow = hashMap.get(slow.next);
            fast = hashMap.get(fast.next);
            if (fast.next.equals("-1")) {
                break;
            } else {
                fast = hashMap.get(fast.next);
            }
        }
        System.out.println(slow.val);
    }

    static class ListNode {
        int val;
        String next;

        public ListNode(int val, String next) {
            this.val = val;
            this.next = next;
        }
    }
}
