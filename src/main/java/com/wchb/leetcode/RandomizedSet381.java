package com.wchb.leetcode;

import java.util.*;

/**
 * @date 8/14/18 7:44 AM
 */
public class RandomizedSet381 {

    private Map<Integer, Set<Integer>> map;
    private ArrayList<Integer> list;
    private Random random;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet381() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    /**
     * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
     */
    public boolean insert(int val) {
        boolean ret = !map.containsKey(val);

        return ret;
    }

    /**
     * Removes a value from the collection. Returns true if the collection contained the specified element.
     */
    public boolean remove(int val) {

        return true;
    }

    /**
     * Get a random element from the collection.
     */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

}
