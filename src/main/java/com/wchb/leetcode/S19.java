package com.wchb.leetcode;

import com.wchb.course3.chapter5.ListNode;

/**
 * @date 6/18/18 10:09 PM
 */
public class S19 {


    //先遍历一遍计算length
    public ListNode removeNthFromEnd(ListNode head, int n) {

        if (head == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        int length = 0;
        ListNode prev = dummyHead;

        while (prev.next != null) {
            length++;

            prev = prev.next;
        }

        int target = length - n + 1;

        int i = 0;
        prev = dummyHead;
        while (prev != null && prev.next != null) {

            i++;

            if (i == target) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            }

            prev = prev.next;
        }


        return dummyHead.next;
    }

    //遍历1遍
    public ListNode removeNthFromEndV2(ListNode head, int n) {
        assert n >= 0;
        if (head == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode p = dummyHead;
        ListNode q = p.next;

        while (n > 0) {
            n--;
            q = q.next;
        }

        while (q != null) {
            p = p.next;
            q = q.next;
        }

        ListNode delNote = p.next;
        p.next = delNote.next;
        delNote.next = null;

        return dummyHead.next;
    }
}
