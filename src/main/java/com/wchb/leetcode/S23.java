package com.wchb.leetcode;


import java.util.PriorityQueue;

/**
 * @date 8/23/18 1:40 PM
 */
public class S23 {
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<Integer> q = new PriorityQueue<>();

        for (ListNode listNode : lists) {
            while (listNode != null) {
                q.add(listNode.val);
                listNode = listNode.next;
            }
        }

        if (q.size() == 0) return null;


        ListNode ret = new ListNode(q.remove());


        ListNode p = ret;
        while (!q.isEmpty()) {
            p.next = new ListNode(q.remove());
            p = p.next;
        }

        return ret;
    }

    /************************************************************/

}
