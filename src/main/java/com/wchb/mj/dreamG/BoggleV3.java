package com.wchb.mj.dreamG;

import java.util.*;

/**
 * @date 12/15/18 1:43 PM
 */
public class BoggleV3 {
    Set<String> res = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }

        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, visited, "", i, j, trie);
            }
        }

        return new ArrayList<String>(res);
    }

    public void dfs(char[][] board, boolean[][] visited, String str, int x, int y, Trie trie) {
        if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) return;
        if (visited[x][y]) return;

        str += board[x][y];
        if (!trie.startsWith(str)) return;

        if (trie.search(str)) {
            res.add(str);
        }

        visited[x][y] = true;
        dfs(board, visited, str, x - 1, y, trie);
        dfs(board, visited, str, x + 1, y, trie);
        dfs(board, visited, str, x, y - 1, trie);
        dfs(board, visited, str, x, y + 1, trie);
        dfs(board, visited, str, x + 1, y + 1, trie);
        dfs(board, visited, str, x - 1, y - 1, trie);
        dfs(board, visited, str, x + 1, y - 1, trie);
        dfs(board, visited, str, x - 1, y + 1, trie);
        visited[x][y] = false;
    }

    class Trie {

        private Node root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new Node();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            Node curNode = root;
            for (int i = 0; i < word.length(); i++) {
                char cur = word.charAt(i);

                if (curNode.next.get(cur) == null) {
                    curNode.next.put(cur, new Node());
                }
                curNode = curNode.next.get(cur);
            }

            if (!curNode.isWord) {
                curNode.isWord = true;
            }
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            Node curNode = root;
            for (int i = 0; i < word.length(); i++) {
                char cur = word.charAt(i);
                if (curNode.next.get(cur) == null) return false;
                curNode = curNode.next.get(cur);
            }

            return curNode.isWord;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            Node curNode = root;
            for (int i = 0; i < prefix.length(); i++) {
                char cur = prefix.charAt(i);
                if (curNode.next.get(cur) == null) return false;
                curNode = curNode.next.get(cur);
            }
            return true;
        }

        private class Node {

            public Map<Character, Node> next;
            public boolean isWord;

            public Node(boolean isWord) {
                this.isWord = isWord;
                next = new TreeMap<>();
            }

            public Node() {
                this(false);
            }
        }
    }
}
