package com.wchb.leetcode;


import com.wchb.course1.chapter8.PriorityQueue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution347 {

    public List<Integer> topKFrequent(int[] nums, int k) {

        PriorityQueue<Freq> pq = new PriorityQueue<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (pq.getSize() < k) {
                pq.enqueue(new Freq(entry.getKey(), entry.getValue()));
            } else if (map.get(entry.getKey()) > pq.getFront().freq) {
                pq.dequeue();
                pq.enqueue(new Freq(entry.getKey(), entry.getValue()));
            }
        }

        List<Integer> res = new LinkedList<>();
        while (!pq.isEmpty()) {
            res.add(pq.dequeue().e);
        }

        return res;
    }

    private class Freq implements Comparable<Freq> {
        Integer e, freq;

        public Freq(Integer e, Integer freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        //频次越低 优先级越高
        public int compareTo(Freq another) {
            if (this.freq < another.freq) {
                return 1;//当前元素比传进来元素大(优先级) 返回1
            } else if (this.freq > another.freq) {
                return -1;
            } else {
                return 0;
            }
        }
    }

}
