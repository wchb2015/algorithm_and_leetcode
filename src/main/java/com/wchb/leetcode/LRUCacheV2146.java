package com.wchb.leetcode;

import java.util.HashMap;

/**
 * @date 8/5/18 11:20 AM
 */

/**
 * Requirements:
 * 1) Access to a random key in o(1) ---> hash table
 * 2) Remove the last entry in LRU cache in o(1) ---> list
 * 3) Add/Move an entry to the front of  in LRU cache in o(1) ---> list
 * <p>
 * Discards the least recently used items first.
 * <p>
 * Doubly linked list
 * 1) The two node links allow traversal of the list in either direction.
 * 2) One interesting property about double linked list is that
 * the node can remove itself without other reference.
 * 3) In addition, it takes constant time to add and remove nodes from the head or tail.
 * <p>
 * get:
 * if key does not exist: return -1;
 * else : move this key to the front of the cache.
 * <p>
 * put:
 * if key already exists: update the value and move this entry to the front of the cache.
 * else :
 * Reached the capacity, remove the oldest entry.
 * Insert the entry to the front of the cache and update mapping
 */
public class LRUCacheV2146 {

    //a hash table that keeps track of the keys and its values in the doubly linked list.
    private HashMap<Integer, Node> map;
    private int size;
    private int capacity;
    private Node tail;
    private Node head;

    class Node {
        public Node prev;
        public Node next;
        public int val;
        public int key;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    public LRUCacheV2146(int capacity) {
        tail = null;
        head = null;
        this.size = 0;
        this.capacity = capacity;
        map = new HashMap<>();
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;
        move2Head(node);

        return node.val;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        // key already exists
        if (node != null) {
            node.val = value;
            move2Head(node);
        } else {
            node = new Node(key, value);
            map.put(key, node);
            if (size == capacity) {
                removeLast();
            }
            addFirst(node);
        }
    }

    // 1(map size)
    private void addFirst(Node node) {
        map.put(node.key, node);
        if (tail == null) {
            head = node;
            tail = node;
        } else {
            node.next = head;
            head.prev = node;
            head = head.prev;
            head.prev = null;
        }
        size++;
    }

    // 2
    private void move2Head(Node node) {
        if (node == head) return;
        remove(node);
        addFirst(node);
    }

    // 3 (map size)
    private void removeLast() {
        if (size == 0) return;
        map.remove(tail.key);
        if (tail.prev != null) {
            tail.prev.next = null;
            tail = tail.prev;
        } else {
            head = null;
            tail = null;
        }
        size--;
    }

    // 4 (map size)
    private void remove(Node node) {
        if (size == 0) return;
        if (node.next == null) {
            removeLast();
        } else if (node.prev == null) {
            head = head.next;
            head.prev = null;

            size--;
            map.remove(node.key);
        } else {
            Node prev = node.prev;

            prev.next = node.next;
            node.next.prev = node.prev;

            node.next = null;
            node.prev = null;

            size--;
            map.remove(node.key);
        }

    }

}
