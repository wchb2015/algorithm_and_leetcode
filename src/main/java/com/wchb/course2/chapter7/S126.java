package com.wchb.course2.chapter7;

import java.util.*;

/**
 * @date 8/7/18 4:54 PM
 */
public class S126 {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList);
        List<List<String>> ans = new LinkedList<>();
        List<String> path = new LinkedList<>();
        Map<String, List<String>> g = new HashMap<>();
        Map<String, Integer> dist = new HashMap<>();
        if (!wordSet.contains(endWord)) return ans;


        // it is not necessary, but it is good to add beginWord into the set,
        // so that we will have a complete graph that contains all nodes
        wordSet.add(beginWord);

        bfs(g, dist, beginWord, wordSet);

        path.add(beginWord);
        dfs(ans, path, beginWord, endWord, dist, g);

        return ans;
    }

    // 利用BFS构建一幅图 adjacency list 表示
    public void bfs(Map<String, List<String>> g, Map<String, Integer> dist,
                    String beginWord, Set<String> wordSet) {

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        dist.put(beginWord, 0);

        for (String w : wordSet) g.put(w, new LinkedList<>());

        while (!queue.isEmpty()) {
            String cur = queue.poll();
            List<String> neighbors = getNeighbors(cur, wordSet);

            for (String neighbor : neighbors) {
                g.get(cur).add(neighbor);

                if (dist.containsKey(neighbor)) continue;
                dist.put(neighbor, dist.get(cur) + 1);
                queue.offer(neighbor);
            }
        }

    }


    // 利用深度优先搜多找出所有的最短路径
    public void dfs(List<List<String>> ans, List<String> path,
                    String beginWord, String endWord,
                    Map<String, Integer> dist, Map<String, List<String>> graph) {

        if (beginWord.equals(endWord)) {
            ans.add(new LinkedList<>(path));
            return;
        }

        for (String neighbor : graph.get(beginWord)) {
            if (dist.get(beginWord) + 1 != dist.get(neighbor)) {
                //System.out.println(beginWord+"----" +neighbor);
                continue;
            }
            path.add(neighbor);
            dfs(ans, path, neighbor, endWord, dist, graph);
            path.remove(path.size() - 1);

        }
    }

    static List<String> getNeighbors(String word, Set<String> wordSet) {
        List<String> res = new LinkedList<>();
        for (int i = 0; i < word.length(); i++) {
            char[] chs = word.toCharArray();
            char old = chs[i];
            for (char ch = 'a'; ch < 'z' + 1; ch++) {
                if (old == ch) continue;
                chs[i] = ch;
                String next = new String(chs);
                if (wordSet.contains(next)) {
                    res.add(next);
                }
            }
        }
        return res;
    }


}
