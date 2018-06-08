package com.wchb.leetcode;

import java.util.Objects;

/**
 * @date 6/6/18 9:41 AM
 */
public class S237 {

    public void deleteNode(ListNode node) {

        node.val = node.next.val;

        node.next = node.next.next;
    }


    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}

