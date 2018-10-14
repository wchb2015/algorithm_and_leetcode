package com.wchb.leetcode;

/**
 * @date 8/8/18 10:59 PM
 */
public class S147 {

    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode curP = head;
        while (curP != null && curP.next != null) {
            if (curP.val > curP.next.val) {
                ListNode next = curP.next;
                ListNode pre = dummyHead;
                curP.next = next.next;
                while (pre.next.val <= next.val) {
                    pre = pre.next;
                }
                next.next = pre.next;
                pre.next = next;
            } else {
                curP = curP.next;
            }
        }
        return dummyHead.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
