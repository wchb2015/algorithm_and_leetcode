package com.wchb.leetcode;

/**
 * @date 8/24/18 7:52 AM
 */
public class S25 {

    public ListNode reverseKGroup(ListNode head, int k) {

        if (head == null || head.next == null) return head;
        int count = 0;
        ListNode cur = head;

        while (cur != null && count != k) {
            cur = cur.next;
            count++;
        }

        System.out.println(" head: " + head.val + " cur: " + cur.val);

        if (count == k) {
            cur = reverseKGroup(cur, k);
            while (count > 0) {
                count--;
                ListNode temp = head.next;
                head.next = cur;
                cur = head;
                head = temp;
            }

            head = cur;
        }

        return head;
    }
}
