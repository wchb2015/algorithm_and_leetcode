package com.wchb.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @date 9/20/18 8:56 PM
 */
public class S399 {

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        int n = equations.length;

        //build graph
        Map<String, Map<String, Double>> g = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String from = equations[i][0];
            String to = equations[i][1];
            double val = values[i];

            if (!g.containsKey(from)) g.put(from, new HashMap<>());
            if (!g.containsKey(to)) g.put(to, new HashMap<>());


            g.get(from).put(to, val);
            g.get(to).put(from, 1.0 / val);
        }

        //do dfs
        double[] ans = new double[queries.length];

        for (int i = 0; i < queries.length; i++) {
            ans[i] = dfs(g, queries[i][0], queries[i][1], new HashSet<>());
        }

        return ans;
    }

    private double dfs(Map<String, Map<String, Double>> g, String from, String to, Set<String> visited) {

        if (!g.containsKey(from) || !g.containsKey(to)) return -1.0;

        if (from.equals(to)) return 1.0;
        visited.add(from);

        Map<String, Double> adjs = g.get(from);

        for (String n : adjs.keySet()) {
            if (visited.contains(n)) continue;
            visited.add(n);
            double d = dfs(g, n, to, visited);
            if (d > 0) return d * g.get(from).get(n);
        }

        return -1.0;
    }

}