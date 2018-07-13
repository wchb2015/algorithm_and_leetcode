package com.wchb.leetcode;

import java.util.Iterator;
import java.util.LinkedHashMap;

/**
 * @date 7/12/18 7:38 AM
 */
public class LRUCache146 {
    private int capacity;
    private LinkedHashMap<Integer, Integer> data;

    public LRUCache146(int capacity) {
        this.capacity = capacity;
        this.data = new LinkedHashMap<>();
    }

    public int get(int key) {
        Integer value = this.data.get(key);
        if (value == null) {
            value = -1;
        } else {
            this.put(key, value);
        }
        return value;
    }

    public void put(int key, int value) {
        if (this.data.containsKey(key)) {
            this.data.remove(key);
        } else if (this.data.size() == this.capacity) {
            Iterator<Integer> it = this.data.keySet().iterator();
            it.next();
            it.remove();
        }
        data.put(key, value);
    }


    @Override
    public String toString() {
        return "LRUCache146{" +
                "capacity=" + capacity +
                ", data=" + data +
                '}';
    }
}
