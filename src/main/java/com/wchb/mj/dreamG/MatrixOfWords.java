package com.wchb.mj.dreamG;

/**
 * @date 12/1/18 1:08 PM
 */
public class MatrixOfWords {


    boolean[][] visited;

    public boolean solution(String[][] matrix, String from, String to) {

        int rows = matrix.length;
        int cols = matrix[0].length;
        visited = new boolean[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j].equals(from) && dfs(matrix, i, j, from, to)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean dfs(String[][] matrix, int startX, int startY, String from, String to) {

        if (visited[startX][startY]) return false;
        if (startX >= matrix.length || startY >= matrix[0].length) return false;


        visited[startX][startY] = true;
        if (matrix[startX][startY].equals(to)) return true;

        char lastChar = from.charAt(from.length() - 1);
        boolean b1 = false;
        if (startX + 1 < matrix.length) {
            String nextRow = matrix[startX + 1][startY];
            if (nextRow.charAt(0) == lastChar) {
                b1 = dfs(matrix, startX + 1, startY, nextRow, to);
            }
        }

        boolean b2 = false;

        if (startY + 1 < matrix[0].length) {
            String nextCol = matrix[startX][startY + 1];
            if (nextCol.charAt(0) == lastChar) {
                b2 = dfs(matrix, startX, startY + 1, nextCol, to);
            }
        }

        return b1 || b2;
    }
}
