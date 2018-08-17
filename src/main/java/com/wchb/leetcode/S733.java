package com.wchb.leetcode;

/**
 * @date 8/16/18 9:28 PM
 */
public class S733 {
    int row = 0;
    int col = 0;
    int oldColor = 0;

    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        row = image.length;
        col = image[0].length;
        if (row == 0 || col == 0) return image;
        oldColor = image[sr][sc];
        dfs(image, sr, sc, newColor);

        return image;
    }

    private void dfs(int[][] image, int x, int y, int newColor) {
        if (!inArea(x, y) || image[x][y] == newColor || image[x][y] != oldColor) {
            return;
        }
        image[x][y] = newColor;
        dfs(image, x + 1, y, newColor);
        dfs(image, x - 1, y, newColor);
        dfs(image, x, y + 1, newColor);
        dfs(image, x, y - 1, newColor);
    }

    private boolean inArea(int x, int y) {
        return x >= 0 && x < row && y >= 0 && y < col;
    }

}
