package com.wchb.leetcode;

import java.util.LinkedList;

/**
 * @date 8/8/18 9:37 AM
 */
public class S86 {
    public ListNode partition(ListNode head, int x) {

        ListNode p = head;
        LinkedList<Integer> lessThanX = new LinkedList<>();
        LinkedList<Integer> equalOrGreaterX = new LinkedList<>();

        while (p != null) {
            if (p.val < x) {
                lessThanX.add(p.val);
            } else {
                equalOrGreaterX.add(p.val);
            }
            p = p.next;
        }

        if (lessThanX.size() == 0) return head;

        ListNode newHead = new ListNode(lessThanX.removeFirst());
        ListNode p2 = newHead;
        while (!lessThanX.isEmpty()) {
            p2.next = new ListNode(lessThanX.removeFirst());
            p2 = p2.next;
        }

        while (!equalOrGreaterX.isEmpty()) {
            p2.next = new ListNode(equalOrGreaterX.removeFirst());
            p2 = p2.next;
        }

        return newHead;
    }

    /************************************************************/

    public ListNode partitionV2(ListNode head, int x) {

        ListNode p = head;
        ListNode lessThanX = new ListNode(0);
        ListNode equalOrGreaterX = new ListNode(0);


        ListNode pl = lessThanX;
        ListNode pe = equalOrGreaterX;
        while (p != null) {
            if (p.val < x) {
                pl.next = new ListNode(p.val);
                pl = pl.next;
            } else {
                pe.next = new ListNode(p.val);
                pe = pe.next;
            }
            p = p.next;
        }

        pl.next = equalOrGreaterX.next;

        return lessThanX.next;
    }


    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
