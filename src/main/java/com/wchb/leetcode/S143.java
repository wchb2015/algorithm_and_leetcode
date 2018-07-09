package com.wchb.leetcode;


/**
 * @date 7/8/18 10:51 AM
 */
public class S143 {
    public void reorderList(ListNode head) {

        if (head == null || head.next == null) {
            return;
        }

        ListNode pMid = findMidPos(head);

        pMid = reverseList(pMid);
        head = merge(head, pMid);
    }


    private ListNode findMidPos(ListNode head) {


        ListNode dummyHead = new ListNode(-1);
        dummyHead.next = head;
        ListNode slow = head;
        ListNode quick = head;

        while (quick != null && quick.next != null) {
            dummyHead = dummyHead.next;
            slow = slow.next;
            quick = quick.next.next;
        }

        dummyHead.next = null;

        return slow;
    }

    private ListNode reverseList(ListNode head) {

        if (head == null || head.next == null) {
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;

            cur.next = pre;
            pre = cur;
            cur = next;
        }

        return pre;
    }

    private ListNode merge(ListNode node1, ListNode node2) {

        if (node1 == null) {
            return node2;
        }

        if (node2 == null) {
            return node1;
        }

        ListNode dummyHead = new ListNode(-1);
        ListNode p = dummyHead;

        int i = 0;
        while (node1 != null && node2 != null) {
            if (i % 2 == 0) {
                p.next = node1;
                node1 = node1.next;
            } else {
                p.next = node2;
                node2 = node2.next;
            }
            i++;
            p = p.next;
        }
        p.next = node1 == null ? node2 : node1;


        printList("ddd ", dummyHead.next);
        return dummyHead.next;
    }


    private void printList(String prefix, ListNode head) {
        StringBuilder sb = new StringBuilder();
        sb.append(prefix);
        while (head != null) {
            sb.append(head.val).append("->");
            head = head.next;
        }

        sb.append("null");
        System.out.println(sb.toString());
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }


        @Override
        public String toString() {
            return "ListNode{" +
                    "val=" + val +
                    '}';
        }
    }


    public ListNode builder(int[] arr) {
        ListNode p = new ListNode(-1);
        ListNode node = p;
        for (int i = 0; i < arr.length; i++) {
            node.next = new ListNode(arr[i]);
            node = node.next;
        }
        return p.next;
    }

}
