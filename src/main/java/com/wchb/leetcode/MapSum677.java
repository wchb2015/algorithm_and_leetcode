package com.wchb.leetcode;

/**
 * @date 6/6/18 6:06 PM
 */

import java.util.TreeMap;

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */
public class MapSum677 {

    private class Node {

        public int val;

        public TreeMap<Character, Node> next;

        public Node(int val) {
            this.val = val;
            next = new TreeMap<>();
        }

        public Node() {
            this(0);
        }
    }

    private Node root;

    /**
     * Initialize your data structure here.
     */
    public MapSum677() {
        root = new Node(0);
    }

    public void insert(String key, int val) {
        Node cur = root;
        for (int i = 0; i < key.length(); i++) {
            char c = key.charAt(i);
            if (cur.next.get(c) == null) {
                cur.next.put(c, new Node());
            }
            cur = cur.next.get(c);
        }
        cur.val = val;
    }

    public int sum(String prefix) {

        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.next.get(c) == null) {
                return 0;
            }
            cur = cur.next.get(c);
        }

        return sum(cur);
    }

    private int sum(Node node) {

        //递归到底的情况. node为叶子节点
        if (node.next.size() == 0) {
            return node.val;
        }

        int ret = node.val;
        for (char c : node.next.keySet()) {
            ret += sum(node.next.get(c));
        }
        return ret;
    }

}
