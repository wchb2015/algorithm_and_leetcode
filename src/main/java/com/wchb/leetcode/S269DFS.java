package com.wchb.leetcode;

import java.util.*;

/**
 * @date 12/14/18 9:23 AM
 */
public class S269DFS {

    // visited[i] = -1. Not even exist.
    // visited[i] = 0. Exist. Non-visited.
    // visited[i] = 1. Visiting.
    // visited[i] = 2. Visited;
    private Map<Character, Set<Character>> g;
    private int[] visited;
    private StringBuilder sb;

    public String alienOrder(String[] words) {

        int n = words.length;
        if (n == 0) return "";

        g = new HashMap<>();
        visited = new int[26];
        sb = new StringBuilder();
        Arrays.fill(visited, -1);
        buildGraph(words);

        for (int i = 0; i < 26; i++) {
            if (visited[i] != 0) continue;
            if (dfs(i)) return "";
        }

        return sb.reverse().toString();
    }

    // return false if has cycle.
    private boolean dfs(int v) {

        visited[v] = 1;
        char key = (char) (v + 'a');

        if (g.get(key) == null || g.get(key).size() == 0) {
            visited[v] = 2;
            sb.append(key);
            return false;
        }

        for (Character adj : g.get(key)) {
            if (visited[adj - 'a'] == 1) return true;
            if (visited[adj - 'a'] == 0) {
                if (dfs(adj - 'a')) return true;
            }
        }

        visited[v] = 2;
        sb.append(key);

        return false;
    }


    private void buildGraph(String[] words) {
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                visited[c - 'a'] = 0;
            }
        }
        for (int i = 1; i < words.length; i++) {
            String word1 = words[i - 1];
            String word2 = words[i];

            int len = Math.min(word1.length(), word2.length());

            for (int j = 0; j < len; j++) {
                if (word1.charAt(j) == word2.charAt(j)) continue;

                char from = word1.charAt(j);
                char to = word2.charAt(j);

                // avoid add duplicate edges
                if (g.containsKey(from) && g.get(from).contains(to)) break;

                if (!g.containsKey(from)) g.put(from, new HashSet<>());
                g.get(from).add(to);

                break;
            }
        }
    }
}
