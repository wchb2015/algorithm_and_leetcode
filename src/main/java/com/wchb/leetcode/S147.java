package com.wchb.leetcode;

/**
 * @date 8/8/18 10:59 PM
 */
public class S147 {

    public ListNode insertionSortList(ListNode head) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;


        ListNode cur = head;
        while (cur != null && cur.next != null) {
            //Compare and Insert
            if (cur.val > cur.next.val) {
                //current head;
                ListNode tmp = cur.next;
                ListNode pre = dummyHead;

                cur.next = tmp.next;


                while (pre.next.val <= tmp.val) {
                    pre = pre.next;
                }

                tmp.next = pre.next;
                pre.next = tmp;

            } else {
                cur = cur.next;
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
