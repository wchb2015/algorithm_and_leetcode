package com.wchb.course2.chapter7;

import java.util.*;

/**
 * @date 8/7/18 4:54 PM
 */
public class S126 {

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        List<List<String>> ret = new LinkedList<>();
        Set<String> wordSet = new HashSet<>(wordList);

        if (!wordSet.contains(endWord)) return ret;

        wordSet.add(beginWord);

        List<String> path = new ArrayList<>();
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> dist = new HashMap<>();

        bfs(graph, dist, beginWord, wordSet);
        dfs(ret, path, endWord, beginWord, dist, graph);

        return ret;
    }

    // 利用BFS构建一幅图 adjacency list 表示
    public void bfs(Map<String, List<String>> graph, Map<String, Integer> dist,
                    String beginWord, Set<String> wordSet) {

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        dist.put(beginWord, 0);

        for (String w : wordSet) {
            graph.put(w, new ArrayList<>());
        }

        while (!queue.isEmpty()) {
            String word = queue.poll();
            List<String> neighbors = getNeighbors(word, wordSet);
            for (String neighbor : neighbors) {
                graph.get(neighbor).add(word);
                if (!dist.containsKey(neighbor)) {
                    dist.put(neighbor, dist.get(word) + 1);
                    queue.offer(neighbor);
                }
            }
        }
    }

    // 利用深度优先搜多找出所有的最短路径
    public static void dfs(List<List<String>> res, List<String> path,
                           String word, String beginWord,
                           Map<String, Integer> dist, Map<String,
            List<String>> graph) {

        if (word.equals(beginWord)) {
            path.add(0, word);
            res.add(new ArrayList<>(path));
            path.remove(0);
            return;
        }

        for (String neighbor : graph.get(word)) {
            if (dist.containsKey(neighbor) && dist.get(word) == dist.get(neighbor) + 1) {
                path.add(0, word);
                dfs(res, path, neighbor, beginWord, dist, graph);
                path.remove(0);
            }
        }

    }


    private List<String> getNeighbors(String word, Set<String> wordSet) {
        List<String> res = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            for (char ch = 'a'; ch < 'z' + 1; ch++) {
                char[] chs = word.toCharArray();
                if (ch != chs[i]) {
                    chs[i] = ch;
                    String next = new String(chs);
                    //System.out.println(next);
                    if (wordSet.contains(next)) {
                        res.add(next);
                    }
                }
            }
        }
        return res;
    }


}
