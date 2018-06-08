package com.wchb.leetcode;

import java.util.Objects;

/**
 * @date 6/6/18 10:09 AM
 */
public class S203 {

    public ListNode removeElements(ListNode head, int val) {

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            }
            prev = prev.next;
            if (prev == null) {
                return dummyHead.next;
            }
        }

        return dummyHead.next;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }


    public void justRun() {

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        new S203().removeElements(n3, 1);
    }

}

// Node prev = dummyHead;
//        while (prev.next != null) {
//            if (prev.next.e.equals(e)) {
//                break;
//            }
//            prev = prev.next;
//        }
//
//        if (prev.next != null) {
//            Node delNode = prev.next;
//            prev.next = delNode.next;
//            delNode.next = null;
//            size--;
//        }