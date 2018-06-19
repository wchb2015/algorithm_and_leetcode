package com.wchb.leetcode;

import com.wchb.annotations.CreatedByMyself;
import com.wchb.course3.chapter5.ListNode;

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


    public ListNode swapPairsV2(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode prev = dummyHead;

        while (prev != null && prev.next != null && prev.next.next != null) {

            ListNode node1 = prev.next;
            ListNode node2 = prev.next.next;
            ListNode next = prev.next.next.next;

            prev.next = node2;
            node1.next = next;
            node2.next = node1;

            prev = node1;
        }

        return dummyHead.next;
    }


    private void swap(ListNode nodeA, ListNode nodeB) {
        int temp = nodeA.val;
        nodeA.val = nodeB.val;
        nodeB.val = temp;
    }


}
