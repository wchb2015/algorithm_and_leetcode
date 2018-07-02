package com.wchb.leetcode;

import java.util.*;

/**
 * @date 6/30/18 11:44 AM
 */
public class S692 {


    public List<String> topKFrequentV2(String[] words, int k) {

        Map<String, Integer> map = new HashMap<>();

        for (String s : words) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }

        PriorityQueue<String> pq = new PriorityQueue<>((w1, w2) -> map.get(w1).equals(map.get(w2)) ?
                w2.compareTo(w1) : map.get(w1) - map.get(w2));

        for (String word : map.keySet()) {
            pq.add(word);
            if (pq.size() > k) {
                pq.remove();
            }
        }

        List<String> ans = new ArrayList();
        while (!pq.isEmpty()) {
            ans.add(pq.remove());
        }
        Collections.reverse(ans);
        return ans;
    }


    /************************************************************/


    public List<String> topKFrequent(String[] words, int k) {

        Map<String, Integer> map = new HashMap<>();

        for (String s : words) {
            if (map.containsKey(s)) {
                map.put(s, map.get(s) + 1);
            } else {
                map.put(s, 1);
            }
        }

        PriorityQueue<Freq> pq = new PriorityQueue<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            if (pq.size() < k) {
                pq.add(new Freq(entry.getKey(), entry.getValue()));
            } else if (pq.peek().freq == entry.getValue() &&
                    pq.peek().s.compareTo(entry.getKey()) > 0) {
                pq.remove();
                pq.add(new Freq(entry.getKey(), entry.getValue()));
            } else if (pq.peek().freq < entry.getValue()) {
                pq.remove();
                pq.add(new Freq(entry.getKey(), entry.getValue()));
            }
        }


        LinkedList<String> ret = new LinkedList<>();
        while (pq.size() > 0) {
            ret.addFirst(pq.remove().s);
        }

        return ret;
    }


    private class Freq implements Comparable<Freq> {
        public String s;
        public Integer freq;

        public Freq(String s, Integer freq) {
            this.s = s;
            this.freq = freq;
        }

        @Override
        public int compareTo(Freq another) {
            int i = this.freq - another.freq;

            if (i == 0) {
                return another.s.compareTo(this.s);
//                return this.s.compareTo(another.s);
            } else {
                return i;
            }
        }

        @Override
        public String toString() {
            return "Freq{" +
                    "s='" + s + '\'' +
                    ", freq=" + freq +
                    '}';
        }
    }
}
