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
    private int capacity;
    private int size;
    //a hash table that keeps track of the keys and its values in the doubly linked list.
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
        if (node == null) return -1;
        move2Head(node);
        return node.value;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            node.value = value;
            move2Head(node);
        } else {
            if (size == capacity) {
                Node del = removeLast();
                map.remove(del.key);
                size--;
            }

            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addFirst(newNode);
            size++;
        }
    }

    private void move2Head(Node node) {
        if (node == head) return;
        removeNode(node);
        addFirst(node);
    }

    private Node removeLast() {

        Node node = tail;

        if (tail.prev != null) {
            tail.prev.next = null;
            tail = tail.prev;
        } else {
            head = null;
            tail = null;
        }

        return node;
    }

    private Node removeNode(Node node) {

        if (node == null) return node;

        if (node.prev != null) {
            node.prev.next = node.next;
        }
        if (node.next != null) {
            node.next.prev = node.prev;
        } else {
            tail = tail.prev;
        }

        node.prev = null;
        node.next = null;
        return node;
    }

    private void addFirst(Node newNode) {
        if (head == null) {
            head = newNode;
            tail = newNode;
            return;
        }

        head.prev = newNode;
        newNode.next = head;
        newNode.prev = null;
        head = newNode;
    }

}
