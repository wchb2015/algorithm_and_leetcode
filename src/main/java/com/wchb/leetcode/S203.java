package com.wchb.leetcode;

import com.wchb.course3.chapter5.ListNode;

import java.util.Objects;

/**
 * @date 6/6/18 10:09 AM
 */
public class S203 {


    //标准的跟着刘玉波的解
    public ListNode removeElementsV180618(ListNode head, int val) {

        if (head == null) {
            return head;
        }

        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;

        ListNode cur = dummyHead;
        while (cur.next != null) {
            if (cur.next.val == val) {
                ListNode delNode = cur.next;
                cur.next = delNode.next;
                delNode.next = null;
            } else {
                cur = cur.next;
            }

        }
        return dummyHead.next;
    }


    public void justRun() {

        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(1);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(1);

        n1.next = n2;
        n2.next = n3;
        n3.next = n4;

        System.out.println(ListNode.printList(new S203().removeElementsV180618(n3, 1)));
    }

}
