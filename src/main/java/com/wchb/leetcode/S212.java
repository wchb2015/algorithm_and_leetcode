package com.wchb.leetcode;

import java.util.*;


/**
 * @date 8/31/18 12:09 PM
 */
public class S212 {
    Trie208 t = new Trie208();
    Set<String> ans = new HashSet<>();
    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public List<String> findWords(char[][] board, String[] words) {
        for (String w : words) {
            t.insert(w);
        }

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, "", i, j, new boolean[m][n]);
                //System.out.println("-------");
            }
        }
        return new LinkedList<>(ans);
    }

    private void dfs(char[][] board, String str, int r, int c, boolean[][] visited) {

        str += board[r][c];
        visited[r][c] = true;
        //System.out.println(str);
        if (!t.startsWith(str)) {
            visited[r][c] = false;
            return;
        }
        if (t.search(str)) {
            ans.add(str);
        }
        for (int[] dir : dirs) {
            int nr = r + dir[0];
            int nc = c + dir[1];
            if (!isValid(nr, nc, board) || visited[nr][nc]) continue;
            dfs(board, str, nr, nc, visited);
        }

        visited[r][c] = false;
    }

    private boolean isValid(int r, int c, char[][] image) {
        if (r < 0 || c < 0 || r >= image.length || c >= image[0].length) {
            return false;
        }
        return true;
    }

    class Trie {
        private class Node {
            public boolean isWord;
            public Map<Character, Node> next;

            public Node(boolean isWord) {
                this.isWord = isWord;
                next = new HashMap<>();
            }
        }

        private Node root;

        public Trie() {
            root = new Node(false);
        }


        private boolean search(String str) {
            Node cur = root;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (!cur.next.containsKey(c)) return false;
                cur = cur.next.get(c);
            }


            return cur.isWord;
        }

        private boolean startWith(String str) {
            Node cur = root;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (!cur.next.containsKey(c)) return false;
                cur = cur.next.get(c);
            }


            return true;
        }

        private void insert(String str) {
            Node cur = root;
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if (!cur.next.containsKey(c)) cur.next.put(c, new Node(false));
                cur = cur.next.get(c);
            }
            cur.isWord = true;
        }
    }

}
