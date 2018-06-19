package com.wchb.leetcode;

import com.wchb.annotations.CreatedByMyself;
import com.wchb.course3.chapter5.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @date 6/5/18 10:03 AM
 */
public class S234 {

    @CreatedByMyself
    public boolean isPalindrome(ListNode head) {
        List<Integer> list = new ArrayList<>();
        while (Objects.nonNull(head)) {
            list.add(head.val);
            head = head.next;
        }
        for (int i = 0; i < list.size() / 2; i++) {
            if (!list.get(i).equals(list.get(list.size() - 1 - i))) {
                return false;
            }
        }
        return true;
    }

    public void justRun() {
        ListNode n1 = new ListNode(-129);
        ListNode n2 = new ListNode(-129);
        ListNode n3 = new ListNode(-129);

        n1.next = n2;
        n2.next = n3;
        System.out.println(isPalindrome(n1));
    }
}



