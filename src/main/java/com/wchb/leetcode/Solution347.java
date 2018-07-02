package com.wchb.leetcode;


import java.util.*;

public class Solution347 {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();


        for (int i : nums) {
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                map.put(i, 1);
            }
        }

        PriorityQueue<Freq> priorityQueue = new PriorityQueue<>();

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (priorityQueue.size() < k) {
                priorityQueue.add(new Freq(entry.getKey(), entry.getValue()));
            } else if (priorityQueue.peek().freq < entry.getValue()) {
                priorityQueue.remove();
                priorityQueue.add(new Freq(entry.getKey(), entry.getValue()));
            }
        }


        Iterator<Freq> iterator = priorityQueue.iterator();
        List<Integer> res = new LinkedList<>();
        while (iterator.hasNext()) {
            res.add(iterator.next().value);
        }

        return res;
    }

    private class Freq implements Comparable<Freq> {
        public Integer value;
        public Integer freq;


        public Freq(Integer value, Integer freq) {
            this.value = value;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another) {
            return this.freq - another.freq;
        }

        @Override
        public String toString() {
            return "Freq{" +
                    "value=" + value +
                    ", freq=" + freq +
                    '}';
        }
    }

}
