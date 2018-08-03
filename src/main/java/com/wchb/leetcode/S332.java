package com.wchb.leetcode;

import java.util.*;

/**
 * @date 8/2/18 4:49 PM
 */
public class S332 {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, LinkedList<String>> map = new HashMap<>();
        LinkedList<String> result = new LinkedList<>();

        for (String[] ticket : tickets) {
            if (!map.containsKey(ticket[0])) {
                LinkedList<String> q = new LinkedList<>();
                map.put(ticket[0], q);
            }
            map.get(ticket[0]).add(ticket[1]);
        }

        for (LinkedList<String> list : map.values()) {
            Collections.sort(list);
        }

        dfs("JFK", result, map);

        return result;
    }


    private void dfs(String s, LinkedList<String> result, Map<String, LinkedList<String>> map) {
        LinkedList<String> q = map.get(s);

        while (!q.isEmpty()) {
            dfs(q.removeFirst(), result, map);
        }

        result.addFirst(s);
    }
}
