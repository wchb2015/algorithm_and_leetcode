package com.wchb.leetcode;

import java.util.Objects;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
public class Solution203 {


    // 递归解法
    public static ListNode removeElementsV4(ListNode head, int val) {
        if (Objects.isNull(head)) {
            return null;
        }

        head.next = removeElementsV4(head.next, val);
        return head.val == val ? head.next : head;

       /* ListNode res = removeElementsV4(head.next, val);
        if (head.val == val) {
            return res;
        } else {
            head.next = res;
            return head;
        }*/
    }


    public static ListNode removeElementsV3(ListNode head, int val) {
        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode prev = dummyHead;

        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else {
                prev = prev.next;

            }
        }

        return dummyHead.next;
    }


    public static ListNode removeElementsV2(ListNode head, int val) {

        while (head != null && head.val == val) {
            ListNode delNode = head;
            head = head.next;
            delNode.next = null;
        }

        if (head == null) {
            return null;
        }

        ListNode prev = head;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            } else {
                prev = prev.next;
            }
        }

        return head;
    }


    public static ListNode removeElementsV1_W(ListNode head, int val) {
        if (head == null) {
            return head;
        }
        ListNode prev = head;
        ListNode cur = head;
        while (cur != null) {
            if (cur.val == val) {
                if (cur == head) {
                    head = head.next;
                    prev = prev.next;
                    cur = cur.next;
                } else {
                    prev.next = cur.next;
                    cur = cur.next;
                }
            } else {

                if (cur != prev) {
                    prev = prev.next;
                }

                cur = cur.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(3);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(3);

        l1.next = l2;
        l2.next = l3;

        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        print(l1);
        l1 = removeElementsV4(l1, 1);
        System.out.println("----------");
        print(l1);
    }

    private static void print(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            System.out.println(cur.val);

            cur = cur.next;
        }
    }
}


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

}





