package com.wchb.leetcode;

import java.util.*;

/**
 * @date 8/2/18 4:49 PM
 */
public class S332 {

    int n;

    public List<String> findItinerary(String[][] tickets) {
        Map<String, LinkedList<String>> map = new HashMap<>();
        LinkedList<String> ans = new LinkedList<>();
        n = tickets.length;

        for (String[] ticket : tickets) {
            if (!map.containsKey(ticket[0])) map.put(ticket[0], new LinkedList<>());
            map.get(ticket[0]).add(ticket[1]);
        }

        for (LinkedList<String> list : map.values()) Collections.sort(list);

        ans.add("JFK");
        dfs("JFK", ans, map);

        return ans;
    }


    private boolean dfs(String s, LinkedList<String> path, Map<String, LinkedList<String>> map) {

        if (path.size() == n + 1) return true;
        if (!map.containsKey(s)) return false;

        List<String> destions = map.get(s);

        for (int i = 0; i < destions.size(); i++) {
            String dest = destions.get(i);
            destions.remove(i);
            path.add(dest);
            if (dfs(dest, path, map)) return true;
            path.removeLast();
            destions.add(i, dest);
        }

        return false;
    }

    /************************************************************/
    public List<String> findItineraryV2(String[][] tickets) {
        Map<String, Integer> map = new HashMap<>();
        List<String> ans = new LinkedList<>();
        Map<String, LinkedList<String>> g = new HashMap<>();
        ans.add("JFK");

        for (String[] edge : tickets) {
            if (!map.containsKey(edge[1])) {
                map.put(edge[1], 1);
            } else {
                map.put(edge[1], map.get(edge[1]) + 1);
            }

            if (!g.containsKey(edge[0])) g.put(edge[0], new LinkedList<>());

            g.get(edge[0]).add(edge[1]);
        }

        for (LinkedList<String> list : g.values()) Collections.sort(list);

        Queue<String> queue = new LinkedList<>();
        queue.add("JFK");


        while (!queue.isEmpty()) {
            // remove that vertex and its outgoing edges
            // from the graph and repeat with the remaining graph.
            String from = queue.remove();

            LinkedList<String> nei = g.get(from);
            if (nei != null) {
                String next = nei.removeFirst();

                map.put(next, map.get(next) - 1);
                if (map.get(next) == 0) {
                    ans.add(next);
                    queue.add(next);
                }
            }
        }


        return ans;
    }
}
