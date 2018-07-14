package com.wchb.leetcode;

/**
 * @date 7/13/18 12:29 PM
 */
public class S142 {
    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode intersection = getIntersection(head);

        if (intersection == null) return null;

        ListNode p = head;

        while (intersection != p) {
            intersection = intersection.next;
            p = p.next;
        }

        return p;
    }


    private ListNode getIntersection(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return slow;
            }
        }

        return null;
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
