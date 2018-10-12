package com.wchb.leetcode;

/**
 * @date 10/11/18 8:12 PM
 */
public class S328 {
    public ListNode oddEvenList(ListNode head) {

        if (head == null || head.next == null) return head;

        ListNode evenHead = new ListNode(0);
        ListNode even = evenHead;
        ListNode oddHead = new ListNode(0);
        ListNode odd = oddHead;

        ListNode p = head;

        boolean isOdd = true;

        while (p != null) {

            if (isOdd) {
                odd.next = p;
                p = p.next;
                odd.next.next = null;
                odd = odd.next;
            } else {
                even.next = p;
                p = p.next;
                even.next.next = null;
                even = even.next;
            }

            isOdd = !isOdd;

        }

        odd.next = evenHead.next;

        return oddHead.next;
    }
}
