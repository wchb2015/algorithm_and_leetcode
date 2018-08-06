package com.wchb.leetcode;

import java.util.HashMap;

/**
 * @date 8/5/18 10:23 AM
 */
public class LFUCache460 {

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

    public LFUCache460(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        this.head = null;
        this.tail = null;
    }

    public int get(int key) {


        return 1;
    }

    public void put(int key, int value) {


    }
}
