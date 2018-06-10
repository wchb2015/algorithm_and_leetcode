package com.wchb.leetcode;

/**
 * @date 6/9/18 1:07 PM
 */
public class S148 {

    //The basic idea of merge sort is this basic recursive idea
// how most of us learned recursion to start with -
//    merge_sort(list) {
//        split list into two halfs, say first and second ;
//        merge_sort(firstHalf);
//        merge_sort(secondHalf);
//        merge(firstHalf,secondHalf);
//    }
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        //get the middle of the list
        ListNode middle = getMiddle(head);

        //split the list into two halfs
        ListNode halfList = middle.next;
        middle.next = null;

        // recurse on that
        return merge(sortList(head), sortList(halfList));
    }

    private ListNode merge(ListNode nodeA, ListNode nodeB) {
        ListNode dummyHead, curr;
        dummyHead = new ListNode(-1);
        curr = dummyHead;
        while (nodeA != null && nodeB != null) {
            if (nodeA.val <= nodeB.val) {
                curr.next = nodeA;
                nodeA = nodeA.next;
            } else {
                curr.next = nodeB;
                nodeB = nodeB.next;
            }
            curr = curr.next;
        }
        curr.next = (nodeA == null) ? nodeB : nodeA;
        return dummyHead.next;
    }


    public ListNode getMiddle(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode slow, fast;
        slow = fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    private class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
