package com.wchb.leetcode;

import java.util.*;

/**
 * @date 8/21/18 1:01 PM
 */
public class S269BFS {

    public String alienOrder(String[] words) {

        Map<Character, List<Character>> g = new HashMap<>();
        int n = words.length;
        int[] in = new int[26];
        Arrays.fill(in, -1);
        // build graph
        init(in, words);
        for (int i = 1; i < n; i++) {
            build(words[i - 1], words[i], g, in);
        }

        int v = 0;
        for (int i : in) if (i != -1) v++;

        //System.out.println(g+"---"+v);
        // check cycle and build ans by using dfs
        StringBuilder sb = new StringBuilder();
        return helper(g, sb, in, v);
    }

    private void build(String from, String to, Map<Character, List<Character>> g, int[] in) {
        for (int i = 0; i < Math.min(from.length(), to.length()); i++) {
            if (from.charAt(i) == to.charAt(i)) {
                continue;
            }

            char f = from.charAt(i);
            char t = to.charAt(i);

            if (!g.containsKey(f)) g.put(f, new LinkedList<>());
            in[t - 'a']++;
            g.get(f).add(t);
            break;
        }
    }

    private String helper(Map<Character, List<Character>> g, StringBuilder path, int[] in, int v) {

        Queue<Character> q = new LinkedList<>();

        for (int i = 0; i < in.length; i++) {
            if (in[i] == -1) continue;
            if (in[i] == 0) {
                v--;
                path.append((char) (i + 'a'));
                q.add((char) (i + 'a'));
            }
        }

        while (!q.isEmpty()) {
            char cur = q.remove();

            List<Character> neis = g.get(cur);
            if (neis == null || neis.size() == 0) continue;

            for (Character nei : neis) {
                in[nei - 'a']--;
                if (in[nei - 'a'] == 0) {
                    q.offer(nei);
                    path.append(nei);
                    v--;
                }
            }
        }

        if (v == 0) return path.toString();
        return "";
    }

    private void init(int[] in, String[] words) {
        for (String w : words) {
            for (int i = 0; i < w.length(); i++) {
                in[w.charAt(i) - 'a'] = 0;
            }
        }
    }

}
