package com.wchb.leetcode;

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
        if (head == null || head.next == null) return head;
        ListNode p1 = head;
        ListNode p2 = head.next;
        // Find the midpoint
        while (p2 != null && p2.next != null) {
            p1 = p1.next;
            p2 = p2.next.next;
        }
        p2 = sortList(p1.next);
        p1.next = null;
        p1 = sortList(head);
        return merge(p1, p2);
    }

    private ListNode merge(ListNode h1, ListNode h2) {
        ListNode fakeHead = new ListNode(Integer.MIN_VALUE);
        ListNode p = fakeHead;
        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                p.next = h1;
                h1 = h1.next;
            } else {
                p.next = h2;
                h2 = h2.next;
            }
            p = p.next;
        }
        p.next = (h1 == null) ? h2 : h1;
        return fakeHead.next;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
