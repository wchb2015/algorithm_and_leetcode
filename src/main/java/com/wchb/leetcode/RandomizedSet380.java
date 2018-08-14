package com.wchb.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @date 8/13/18 10:40 PM
 */
public class RandomizedSet380 {

    private Map<Integer, Integer> map;
    private ArrayList<Integer> list;
    private Random random;

    /**
     * Initialize your data structure here.
     */
    public RandomizedSet380() {
        map = new HashMap<>();
        list = new ArrayList<>();
        random = new Random();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain the specified element.
     */
    public boolean insert(int val) {
        if (map.containsKey(val)) return false;
        map.put(val, list.size());
        list.add(val);
        return true;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified element.
     */
    public boolean remove(int val) {
        if (!map.containsKey(val)) return false;
        int index = map.get(val);
        if (index < list.size() - 1) {
            int lastOne = list.get(list.size() - 1);
            list.set(index, lastOne);
            map.put(lastOne, index);
        }
        map.remove(val);
        list.remove(list.size() - 1);
        return true;
    }

    /**
     * Get a random element from the set.
     */
    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }
}
