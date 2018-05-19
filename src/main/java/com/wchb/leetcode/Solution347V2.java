package com.wchb.leetcode;

import java.util.*;

public class Solution347V2 {

    private class Freq implements Comparable<Freq> {
        Integer e, freq;

        public Freq(Integer e, Integer freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        //频次越低 优先级越高(JDK PriorityQueue 是最小堆)
        public int compareTo(Freq another) {
 /*           if (this.freq < another.freq) {
                return 1;//当前元素比传进来元素大(优先级) 返回1
            } else if (this.freq > another.freq) {
                return -1;
            } else {
                return 0;
            }*/

            return this.freq - another.freq;
        }
    }

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
            if (pq.size() < k) {
                pq.add(new Freq(entry.getKey(), entry.getValue()));
            } else if (map.get(entry.getKey()) > pq.peek().freq) {
                pq.remove();
                pq.add(new Freq(entry.getKey(), entry.getValue()));
            }
        }

        List<Integer> res = new LinkedList<>();
        while (!pq.isEmpty()) {
            res.add(pq.remove().e);
        }

        return res;
    }


}
