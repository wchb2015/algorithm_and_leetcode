package com.wchb.cc189.chapter2;

import com.wchb.course3.chapter5.ListNode;

import java.util.HashSet;
import java.util.Set;

/**
 * @date 8/3/18 10:48 AM
 */

//Write code to remove duplicates from an unsorted linked list.
//How would you solve this problem if a temporary buffer is not allowed?
public class RemoveDups {

    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return head;
        }

        Set<Integer> set = new HashSet<>();
        set.add(head.val);

        ListNode prev = head;

        while (prev != null && prev.next != null) {
            ListNode cur = prev.next;

            if (set.add(cur.val)) {
                //cur没重复
                prev = prev.next;
            } else {
                //cur重复
                prev.next = cur.next;
                cur.next = null;
            }
        }
        return head;
    }


    public static void main(String[] args) {
        int[] arr = new int[]{1, 4, 5, 9, 4, 2, 1};

        ListNode head = new ListNode(arr);

        System.out.println(" Original: " + head.toString());
        deleteDuplicates(head);
        System.out.println(" After: " + head.toString());

    }
}

