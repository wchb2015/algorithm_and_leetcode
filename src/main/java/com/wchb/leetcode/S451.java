package com.wchb.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * @date 10/16/18 5:24 PM
 */
public class S451 {

    public String frequencySort(String s) {

        PriorityQueue<Freq> queue = new PriorityQueue<>((f1, f2) -> f2.freq - f1.freq);
        Map<Character, Integer> map = new HashMap<>();

        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }

        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            queue.add(new Freq(entry.getKey(), entry.getValue()));
        }

        StringBuilder sb = new StringBuilder();
        while (!queue.isEmpty()) {
            Freq freq = queue.remove();

            while (freq.freq > 0) {
                sb.append(freq.c);
                freq.freq--;
            }
        }

        return sb.toString();

    }

    private class Freq {
        char c;
        int freq;

        public Freq(char c, int freq) {
            this.c = c;
            this.freq = freq;
        }
    }
}
