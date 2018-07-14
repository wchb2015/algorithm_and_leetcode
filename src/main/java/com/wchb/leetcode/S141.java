package com.wchb.leetcode;

/**
 * @date 7/13/18 11:05 AM
 */
public class S141 {

    public boolean hasCycle(ListNode head) {

        if (head == null) {
            return false;
        }

        ListNode fast = head.next;
        ListNode slow = head;


        while (fast != null && fast.next != null) {

            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }

        }

        return fast == slow;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
