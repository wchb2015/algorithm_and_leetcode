package com.wchb.leetcode;

import lombok.val;

/**
 * @date 6/9/18 1:07 PM
 */
public class S148 {

    //The basic idea of merge sort is this basic recursive idea
    // how most of us learned recursion to start with -
    //    merge_sort(list) {
    //        split list into two halfs, say first and second ;
    //        merge_sort(firstHalf);
    //        merge_sort(secondHalf);
    //        merge(firstHalf,secondHalf);
    //    }
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head;
        // Find the midpoint
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        fast = sortList(slow.next);
        slow.next = null;
        slow = sortList(head);
        return merge(slow, fast);
    }

    private ListNode merge(ListNode node1, ListNode node2) {
        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead;
        while (node1 != null && node2 != null) {
            if (node1.val < node2.val) {
                p.next = node1;
                node1 = node1.next;
            } else {
                p.next = node2;
                node2 = node2.next;
            }
            p = p.next;
        }
        p.next = (node1 == null) ? node2 : node1;
        return dummyHead.next;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
