package com.wchb.leetcode;

import com.wchb.annotations.CreatedByMyself;

/**
 * @date 6/12/18 9:45 AM
 */
public class S24 {

    @CreatedByMyself
    public ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode ret = head;
        while (head != null && head.next != null) {
            swap(head, head.next);
            head = head.next.next;
        }

        return ret;
    }


    private void swap(ListNode nodeA, ListNode nodeB) {
        int temp = nodeA.val;
        nodeA.val = nodeB.val;
        nodeB.val = temp;
    }


    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
