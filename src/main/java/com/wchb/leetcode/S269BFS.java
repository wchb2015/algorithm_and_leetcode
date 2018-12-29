package com.wchb.leetcode;

import java.util.*;

/**
 * @date 8/21/18 1:01 PM
 */
public class S269BFS {

    int[] charArr;
    int[] inDegree;
    int v;
    Map<Character, LinkedList<Character>> g;

    public String alienOrder(String[] words) {
        StringBuilder sb = new StringBuilder();
        charArr = new int[26];
        inDegree = new int[26];
        g = new HashMap<>();
        v = 0;
        Arrays.fill(charArr, -1);
        Arrays.fill(inDegree, -1);
        // build graph (including inDegree)
        build(words);
        // bfs graph
        Queue<Character> q = new LinkedList<>();

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                q.add((char) (i + 'a'));
                sb.append((char) (i + 'a'));
            }
        }
        System.out.println(g);
        if (q.size() == 0) return "";

        while (!q.isEmpty()) {
            char cur = q.poll();

            List<Character> neis = g.get(cur);
            if (neis == null) {
                continue;
            }
            for (Character nei : neis) {
                inDegree[nei - 'a']--;
                if (inDegree[nei - 'a'] == 0) {
                    q.add(nei);
                    sb.append(nei);
                }
            }
        }
        if (sb.length() != v) return "";
        return sb.toString();
    }

    private void build(String[] words) {
        for (String word : words) {
            for (char c : word.toCharArray()) {
                if (charArr[c - 'a'] == -1) {
                    v++;
                }
                charArr[c - 'a'] = 0;
                inDegree[c - 'a'] = 0;
            }
        }
        for (int i = 1; i < words.length; i++) {
            String w1 = words[i - 1];
            String w2 = words[i];

            int len = Math.min(w1.length(), w2.length());

            for (int j = 0; j < len; j++) {
                if (w1.charAt(j) == w2.charAt(j)) continue;
                char from = w1.charAt(j);
                char to = w2.charAt(j);

                if (!g.containsKey(from)) g.put(from, new LinkedList<>());
                if (g.get(from).contains(to)) break;
                g.get(from).add(to);
                inDegree[to - 'a']++;
                break;
            }
        }
    }

}
