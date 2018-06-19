package com.wchb.leetcode;

import com.wchb.course3.chapter5.ListNode;

import java.util.Objects;

/**
 * @date 6/18/18 4:29 PM
 */
public class S92 {

    // TODO: 6/18/18 找bug.
    public ListNode reverseBetween(ListNode head, int m, int n) {

        if (m == n || head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;
        int index = 1;

//        while (Objects.nonNull(cur)) {
//            ListNode next = cur.next;
//            if (index >= m && index <= n) {
//                cur.next = pre;
//                pre = cur;
//                cur = next;
//            } else {
//                pre = cur;
//                cur = next;
//            }
//            index++;
//        }
//        return pre;
        return null;
    }

//
//    ListNode prev = null;
//    ListNode cur = head;
//
//        while (Objects.nonNull(cur)) {
//        //next的存在依赖cur.
//        ListNode next = cur.next;
//        cur.next = prev;
//        prev = cur;
//        cur = next;
//    }
//
//        return prev;


}
