package com.wchb.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * @date 8/3/18 4:27 PM
 */
public class WordDistance244 {

    private String[] words;

    Map<String, LinkedList<Integer>> map;
    Map<String, Integer> cache;

    public WordDistance244(String[] words) {
        this.words = words;
        map = new HashMap<>();
        cache = new HashMap<>();

        for (int i = 0; i < words.length; i++) {
            if (!map.containsKey(words[i])) map.put(words[i], new LinkedList<>());

            map.get(words[i]).add(i);
        }
    }

    public int shortest(String word1, String word2) {

        String key = word1 + word2;

        if (cache.containsKey(key)) return cache.get(key);
        Integer min = Integer.MAX_VALUE;

        LinkedList<Integer> list1 = map.get(word1);
        LinkedList<Integer> list2 = map.get(word2);
        if (list1.size() < list2.size()) {
            for (int i = 0; i < list1.size(); i++) {
                min = Math.min(min, Math.abs(list1.get(i) - binarySearch(list1.get(i), list2)));
            }
        } else {
            for (int i = 0; i < list2.size(); i++) {
                min = Math.min(min, Math.abs(list2.get(i) - binarySearch(list2.get(i), list1)));
            }
        }

        cache.put(key, min);
        return min;
    }


    private int binarySearch(int value, LinkedList<Integer> list) {

        if (value < list.getFirst()) return list.getFirst();

        if (value > list.getLast()) return list.getLast();

        int l = 0, r = list.size() - 1;


        while (l <= r) {
            int mid = (r + l) / 2;
            if (value < list.get(mid)) {
                r = mid - 1;
            } else if (value > list.get(mid)) {
                l = mid + 1;
            } else {
                return list.get(mid);
            }
        }

        return (list.get(l) - value) < (value - list.get(r)) ? list.get(l) : list.get(r);

    }
}
