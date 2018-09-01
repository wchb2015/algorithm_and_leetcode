package com.wchb.leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


/**
 * @date 8/31/18 12:09 PM
 */
public class S212 {
    boolean[][] visit;
    int m, n;
    int[][] dirs;

    Trie208 t;
    Set<String> ans = new HashSet<>();

    public List<String> findWords(char[][] board, String[] words) {

        m = board.length;
        n = board[0].length;
        visit = new boolean[m][n];
        dirs = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        t = new Trie208();

        for (String word : words) {
            t.insert(word);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, "", i, j);
            }
        }

        return new ArrayList<>(ans);
    }

    private void dfs(char[][] board, String prefix, int x, int y) {
        if (!isValid(x, y) || visit[x][y]) return;

        prefix = prefix + board[x][y];

        if (!t.startsWith(prefix)) return;
        if (t.search(prefix)) ans.add(prefix);

        visit[x][y] = true;
        for (int[] dir : dirs) {
            dfs(board, prefix, x + dir[0], y + dir[1]);
        }
        visit[x][y] = false;
    }


    private boolean isValid(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
