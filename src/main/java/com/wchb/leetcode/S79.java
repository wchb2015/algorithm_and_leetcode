package com.wchb.leetcode;

/**
 * @date 6/21/18 4:44 PM
 */
public class S79 {

    //向4个方向移动的位移 上右下左
    private int d[][] = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private int m, n;
    private boolean[][] visited;

    public boolean exist(char[][] board, String word) {

        if (board == null || word == null) {
            throw new IllegalArgumentException("board or word can not be null!");
        }

        m = board.length;
        if (m == 0) {
            throw new IllegalArgumentException("board can not be empty.");
        }
        n = board[0].length;
        if (n == 0) {
            throw new IllegalArgumentException("board can not be empty.");
        }

        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (searchWord(board, word, 0, i, j)) {
                    return true;
                }
            }
        }

        return false;
    }

    // 从board[startX][startY]开始, 寻找word[index...word.size())
    private boolean searchWord(char[][] board, String word, int index, int startX, int startY) {

        //递归结束
        if (index == word.length() - 1) {
            return board[startX][startY] == word.charAt(index);
        }

        if (board[startX][startY] == word.charAt(index)) {
            visited[startX][startY] = true;
            //从 startX, startY出发,向四个方向寻找
            for (int i = 0; i < 4; i++) {
                int newX = startX + d[i][0];
                int newY = startY + d[i][1];
                if (inArea(newX, newY) && !visited[newX][newY] && searchWord(
                        board, word, index + 1, newX, newY
                )) {
                    return true;
                }
            }
            visited[startX][startY] = false;
        }

        return false;
    }


    private boolean inArea(int x, int y) {
        return x >= 0 && x < m && y >= 0 && y < n;
    }
}
