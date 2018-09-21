package com.wchb.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * @date 9/20/18 8:56 PM
 */
public class S399 {

    int n;
    Map<String, HashMap<String, Double>> g;

    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {

        n = values.length;
        if (n == 0) return new double[]{};
        g = new HashMap<>();
        double[] ans = new double[queries.length];

        for (int i = 0; i < n; ++i) {
            String x = equations[i][0];
            String y = equations[i][1];
            double k = values[i];
            if (!g.containsKey(x)) {
                HashMap<String, Double> map = new HashMap<>();
                map.put(y, k);
                g.put(x, map);
            } else {
                g.get(x).put(y, k);
            }
            if (!g.containsKey(y)) {
                HashMap<String, Double> map = new HashMap<>();
                map.put(x, 1.0d / k);
                g.put(y, map);
            } else {
                g.get(y).put(x, 1.0d / k);
            }
//            g.computeIfAbsent(x, l -> new HashMap<>()).put(y, k);
//            g.computeIfAbsent(y, l -> new HashMap<>()).put(x, 1.0 / k);
        }


        for (int i = 0; i < queries.length; ++i) {
            String from = queries[i][0];
            String to = queries[i][1];
            if (!g.containsKey(from) || !g.containsKey(to)) {
                ans[i] = -1.0;
            } else {
                ans[i] = dfs(from, to, new HashSet<>());
            }
        }

        return ans;
    }

    private double dfs(String from, String to, HashSet<String> visited) {
        if (from.equals(to)) return 1.0;
        visited.add(from);
        if (!g.containsKey(from)) return -1.0d;
        for (String n : g.get(from).keySet()) {
            if (visited.contains(n)) continue;
            visited.add(n);
            double d = dfs(n, to, visited);
            if (d > 0) return d * g.get(from).get(n);
        }
        return -1.0;
    }


}