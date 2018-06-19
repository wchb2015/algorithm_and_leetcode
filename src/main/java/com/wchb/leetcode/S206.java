package com.wchb.leetcode;

import java.util.Objects;

/**
 * @date 6/18/18 3:12 PM
 */
public class S206 {


    // Iterative
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    public ListNode reverseList(ListNode head) {

        if (Objects.isNull(head)) {
            return head;
        }

        ListNode prev = null;
        ListNode cur = head;

        while (Objects.nonNull(cur)) {
            //next的存在依赖cur.
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }

        return prev;
    }

//    public ListNode reverseList(ListNode head) {
//
//        ListNode pre = null;
//        ListNode cur = head;
//        while(cur != null){
//            ListNode next = cur.next;
//            cur.next = pre;
//            pre = cur;
//            cur = next;
//        }
//
//        return pre;
//    }


//    public ListNode reverseList(ListNode head) {
//
//        // 递归终止条件
//        if(head == null|| head.next == null)
//            return head;
//
//        ListNode rhead = reverseList(head.next);
//
//        // head->next此刻指向head后面的链表的尾节点
//        // head->next->next = head把head节点放在了尾部
//        head.next.next = head;
//        head.next = null;
//
//        return rhead;
//    }


    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
