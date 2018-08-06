package com.wchb.leetcode;

import java.util.HashMap;

/**
 * @date 8/5/18 11:20 AM
 */
public class LRUCacheV2146 {
    private int capacity;
    private int size;
    private HashMap<Integer, Node> map;

    private Node head;
    private Node tail;

    private class Node {
        int key;
        int value;

        Node next;
        Node prev;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }

    }

    public LRUCacheV2146(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        this.head = null;
        this.tail = null;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) {
            return -1;
        }
        if (node != tail) {
            if (node == head) {
                head = head.next;
            } else {
                node.prev.next = node.next;
                node.next.prev = node.prev;
            }
            tail.next = node;
            node.prev = tail;
            node.next = null;
            tail = node;
        }
        return node.value;
    }

    //插入: 1不存在 -> capacity -> 1,head = null 2,head != null
    //存在
    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            //存在
            node.value = value;
            if (node != tail) {
                if (node == head) {
                    head = head.next;
                } else {
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                }
                tail.next = node;
                node.prev = tail;
                node.next = null;
                tail = node;
            }
        } else {
            //不存在
            Node newNode = new Node(key, value);
            if (size == capacity) {
                //需要删除元素
                Node temp = head;
                head = head.next;
                map.remove(temp.key);

                temp.prev = null;
                temp.next = null;
                size--;
            }

            //容量还够
            //容量为零
            if (isEmpty()) {
                head = newNode;
            } else {
                //容量不为零
                tail.next = newNode;
                newNode.prev = tail;
                newNode.next = null;
            }

            tail = newNode;
            map.put(key, newNode);
            size++;
        }

    }


    private boolean isEmpty() {
        return size == 0;
    }
}
