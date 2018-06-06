package com.wchb.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;


// 使用JDK的PriorityQueue(最小堆)解决这个问题.
public class Solution347V2 {

    private class Freq implements Comparable<Freq> {
        Integer e, freq;

        public Freq(Integer e, Integer freq) {
            this.e = e;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another) {
            return this.freq - another.freq;
        }
    }

    public List<Integer> topKFrequent(int[] nums, int k) {

        // key element. value: 频次
        Map<Integer, Integer> map = new HashMap<>();

        //先统计频率
        for (Integer num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }

        PriorityQueue<Freq> priorityQueue = new PriorityQueue<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(new Freq(entry.getKey(), entry.getValue()));
            } else if (entry.getValue().compareTo(priorityQueue.peek().freq) > 0) {
                priorityQueue.remove();
                priorityQueue.add(new Freq(entry.getKey(), entry.getValue()));
            }
        }

        List<Integer> res = new java.util.LinkedList<>();
        while (!priorityQueue.isEmpty()) {
            res.add(priorityQueue.remove().e);
        }

        return res;
    }

}
