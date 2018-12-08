package com.wchb.leetcode;

import java.util.*;

/**
 * @date 12/7/18 2:08 PM
 */
public class S815 {
    public int numBusesToDestination(int[][] routes, int from, int to) {

        if (from == to) return 0;

        // stop -> {bus}
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < routes.length; i++) {
            for (int stop : routes[i]) {
                if (!map.containsKey(stop)) map.put(stop, new LinkedList<>());
                map.get(stop).add(i);
            }
        }

        boolean[] visited = new boolean[routes.length];
        Queue<Integer> q = new LinkedList<>();
        q.add(from);
        int buses = 0;

        while (!q.isEmpty()) {
            int size = q.size();
            buses++;

            while (size > 0) {
                size--;

                int cur = q.poll();
                for (int bus : map.get(cur)) {
                    if (visited[bus]) continue;
                    visited[bus] = true;
                    for (int stop : routes[bus]) {
                        if (stop == to) return buses;
                        q.add(stop);
                    }
                }
            }
        }

        return -1;

    }
}
