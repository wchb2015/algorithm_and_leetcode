package com.wchb.leetcode;

import java.util.*;

/**
 * @date 12/9/18 12:02 PM
 */
public class S954 {
    public boolean canReorderDoubled(int[] A) {
        List<Integer> list1 = new LinkedList<>();
        List<Integer> list2 = new LinkedList<>();
        for (int i : A) {
            if (i >= 0) list1.add(i);
            else list2.add(Math.abs(i));
        }

        return validList(list1) && validList(list2);
    }

    private boolean validList(List<Integer> list) {
        if (list.size() == 0) return true;
        if (list.size() % 2 == 1) return false;

        Collections.sort(list);

        Map<Integer, Integer> count = new HashMap<>();
        for (Integer i : list) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }

        for (int x : list) {
            // If this can't be consumed, skip
            if (count.get(x) == 0) continue;
            // If this doesn't have a doubled partner, the answer is false
            if (count.getOrDefault(2 * x, 0) <= 0) return false;

            // Write x, 2*x
            count.put(x, count.get(x) - 1);
            count.put(2 * x, count.get(2 * x) - 1);
        }

        return true;
    }
}
