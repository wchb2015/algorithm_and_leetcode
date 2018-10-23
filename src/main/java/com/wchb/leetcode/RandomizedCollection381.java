package com.wchb.leetcode;

import java.util.*;

/**
 * @date 10/22/18 12:04 PM
 */
public class RandomizedCollection381 {

    private Random random;
    private HashMap<Integer, Set<Integer>> map;
    private ArrayList<Integer> list;

    /**
     * Initialize your data structure here.
     */
    public RandomizedCollection381() {
        random = new Random();
        map = new HashMap<>();
        list = new ArrayList<>();
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {

        boolean contain = map.containsKey(val);

        if (!contain) map.put(val, new LinkedHashSet<>());

        map.get(val).add(list.size());
        list.add(val);

        return !contain;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {

        if (!map.containsKey(val)) return false;

        int idx = map.get(val).iterator().next();

        map.get(val).remove(idx);

        if (idx != list.size() - 1) {
            int lastVal = list.get(list.size() - 1);
            list.set(idx, lastVal);
            map.get(lastVal).remove(list.size() - 1);
            map.get(lastVal).add(idx);
        }

        list.remove(list.size() - 1);
        if (map.get(val).size() == 0) map.remove(val);

        return true;

    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));

    }
}