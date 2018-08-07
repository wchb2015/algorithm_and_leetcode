package com.wchb.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @date 8/7/18 12:44 PM
 */
public class S138 {


    public RandomListNode copyRandomList(RandomListNode head) {

        if (head == null) return head;

        //key : original value: copy
        Map<RandomListNode, RandomListNode> map = new HashMap<>();

        RandomListNode p = head;

        while (p != null) {

            map.put(p, new RandomListNode(p.label));

            p = p.next;
        }

        LinkedList<RandomListNode> list = new LinkedList<>();
        list.add(head);
        while (!list.isEmpty()) {
            RandomListNode cur = list.removeFirst();
            RandomListNode curCopy = map.get(cur);
            if (cur.next != null) {
                curCopy.next = map.get(cur.next);
                list.add(cur.next);
            }
            if (cur.random != null) {
                curCopy.random = map.get(cur.random);
            }

        }

        return map.get(head);
    }


    private class RandomListNode {
        int label;
        RandomListNode next, random;

        RandomListNode(int x) {
            this.label = x;
        }
    }

}
