package com.wchb.leetcode;

import java.util.*;

/**
 * @date 8/21/18 1:01 PM
 */
public class S269 {


    // build graph
    // BFS
    // Add unvisited character
    int[] chars;//0 No 1 unvisited  2 visited
    Map<Character, Set<Character>> g;
    int[] inDegree;
    int v;

    public String alienOrder(String[] words) {

        StringBuilder sb = new StringBuilder();
        chars = new int[26];
        inDegree = new int[26];
        g = new HashMap<>();
        v = 0;

        buildGraph(words);

        if (!bfs(g, sb)) return "";

        return sb.toString();
    }

    private boolean bfs(Map<Character, Set<Character>> g, StringBuilder sb) {

        Queue<Character> queue = new LinkedList<>();

        for (int i = 0; i < 26; i++) {
            if (chars[i] == 1) sb.append((char) ('a' + i));
            if (chars[i] == 2) v++;

            if (chars[i] == 2 && inDegree[i] == 0) {
                sb.append((char) ('a' + i));
                queue.add((char) ('a' + i));
            }
        }


        while (!queue.isEmpty()) {
            char from = queue.poll();
            v--;
            Set<Character> neis = g.get(from);
            if (neis == null) continue;
            for (Character nei : neis) {
                // remove that vertex and its outgoing edges
                // from the graph and repeat with the remaining graph.
                inDegree[nei - 'a']--;
                if (inDegree[nei - 'a'] == 0) {
                    sb.append(nei);
                    queue.offer(nei);
                }
            }
        }
        return v == 0 ? true : false;
    }


    private void buildGraph(String[] words) {
        for (String s : words) {
            for (Character c : s.toCharArray()) {
                chars[c - 'a'] = 1;
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String word1 = words[i];
            String word2 = words[i + 1];
            int len = Math.min(word1.length(), word2.length());

            for (int j = 0; j < len; j++) {
                if (word1.charAt(j) == word2.charAt(j)) continue;

                char from = word1.charAt(j);
                char to = word2.charAt(j);

                if (g.containsKey(from) && g.get(from).contains(to)) break;

                chars[from - 'a'] = 2;
                chars[to - 'a'] = 2;
                inDegree[to - 'a']++;
                if (!g.containsKey(from)) g.put(from, new HashSet<>());
                g.get(from).add(to);
                break;
            }
        }
    }

}
