package com.wchb.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

/**
 * @date 8/21/18 1:01 PM
 */
public class S269 {

    private HashMap<Character, Set<Character>> map;

    // 0 unvisited 1 visiting 2 visited
    int[] visited;
    StringBuilder ans;

    public String alienOrder(String[] words) {

        if (words == null || words.length == 0) return "";
        ans = new StringBuilder();
        buildGraph(words);
        if (map.size() == 0) return String.valueOf(words[0].charAt(0));
        visited = new int[26];

        for (Character c : map.keySet()) {
            if (dfs(c)) {
                System.out.println("hehe");
                return "";
            }
        }

        return ans.reverse().toString();
    }

    // true 有环
    private boolean dfs(char v) {

        if (visited[v - 'a'] == 1) return true;
        if (visited[v - 'a'] == 2) return false;

        visited[v - 'a'] = 1;
        if (map.get(v) != null) {
            for (Character adj : map.get(v)) {
                if (dfs(adj)) return true;
            }
        }

        visited[v - 'a'] = 2;
        ans.append(v);

        return false;
    }

    private void buildGraph(String[] words) {
        map = new HashMap<>();
        int[] degree = new int[26];

        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (degree[c - 'a'] == 0) {
                    degree[c - 'a'] = 1;
                }
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            char[] cur = words[i].toCharArray();
            char[] next = words[i + 1].toCharArray();
            int len = Math.min(cur.length, next.length);
            for (int j = 0; j < len; j++) {
                if (cur[j] != next[j]) {
                    if (!map.containsKey(cur[j])) {
                        map.put(cur[j], new HashSet<>());
                    }
                    if (map.get(cur[j]).add(next[j])) {
                        degree[next[j] - 'a']++;
                    }
                    break;
                }
            }
        }

    }
}
