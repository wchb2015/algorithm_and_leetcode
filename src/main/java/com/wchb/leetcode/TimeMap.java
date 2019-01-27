package com.wchb.leetcode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @date 1/26/19 7:16 PM
 */
public class TimeMap {

    Map<String, PriorityQueue<Pair>> data;

    /**
     * Initialize your data structure here.
     */
    public TimeMap() {
        data = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        if (data.containsKey(key)) {
            data.get(key).add(new Pair(value, timestamp));
        } else {
            data.put(key, new PriorityQueue<>((p1, p2) -> p2.timestamp - p1.timestamp));
            data.get(key).add(new Pair(value, timestamp));
        }
    }

    public String get(String key, int timestamp) {
        if (!data.containsKey(key)) return "";

        PriorityQueue<Pair> pq = data.get(key);

        Iterator<Pair> iterator = pq.iterator();
        while (iterator.hasNext()) {
            Pair p = iterator.next();
            if (p.timestamp <= timestamp) {
                return p.value;
            }
        }
        return "";
    }

    class Pair {
        public String value;
        public int timestamp;

        public Pair(String value, int timestamp) {
            this.value = value;
            this.timestamp = timestamp;
        }
    }
}
