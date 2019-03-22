package com.wchb.leetcode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;


/**
 * @date 3/21/19 11:14 AM
 */
public class S864 {

    private char start = '@';
    private char empty = '.';
    private char wall = '#';

    int min = Integer.MAX_VALUE;


    public int shortestPathAllKeys(String[] grid) {

        int row = grid.length;
        int col = grid[0].length();
        boolean[][] visited = new boolean[row][col];
        Queue<int[]> q = new LinkedList<>();
        int countKey = 0;
        Set<Character> currentKey = new HashSet<>();

        int[] startPos = new int[]{-1, -1};

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i].charAt(j) == start) {
                    startPos = new int[]{i, j};
                } else if (Character.isLowerCase(grid[i].charAt(j))) {
                    countKey++;
                }
            }
        }

        dfs(startPos, visited, 0, countKey, currentKey, grid);

//        int ans = 0;
//
//        while (!q.isEmpty() && countKey > 0) {
//            int levelCount = q.size();
//            for (int i = 0; i < levelCount; i++) {
//
//                int[] cur = q.poll();
//
//                for (int[] dir : dirs) {
//                    int nr = cur[0] + dir[0];
//                    int nc = cur[1] + dir[1];
//                    if (!isValid(nr, nc, row, col)) continue;
//                    if (visited[nr][nc] || grid[nr].charAt(nc) == wall) continue;
//                    visited[nr][nc] = true;
//
//                    if (grid[nr].charAt(nc) == empty) {
//                        q.offer(new int[]{nr, nc});
//                    } else if (Character.isLowerCase(grid[nr].charAt(nc))) {
//                        currentKey.add(Character.toUpperCase(grid[nr].charAt(nc)));
//                        q.offer(new int[]{nr, nc});
//                        countKey--;
//                    } else if (Character.isUpperCase(grid[nr].charAt(nc)) &&
//                            currentKey.contains(grid[nr].charAt(nc))) {
//                        q.offer(new int[]{nr, nc});
//                    }
//                }
//            }
//            ans++;
//        }

        return min == Integer.MAX_VALUE ? -1 : min;

    }


    private void dfs(int[] startPos, boolean[][] visited, int step, int countKey, Set<Character> currentKey, String[] grid) {
        if (countKey == 0) {
            min = Math.min(min, step);
            return;
        }

        for (int[] dir : dirs) {
            int nr = startPos[0] + dir[0];
            int nc = startPos[1] + dir[1];
            if (!isValid(nr, nc, visited.length, visited[0].length)) continue;
            if (visited[nr][nc] || grid[nr].charAt(nc) == wall) continue;


            visited[nr][nc] = true;

            if (grid[nr].charAt(nc) == empty) {
                dfs(new int[]{nr, nc}, visited, step + 1, countKey, currentKey, grid);
            } else if (Character.isLowerCase(grid[nr].charAt(nc))) {
                currentKey.add(Character.toUpperCase(grid[nr].charAt(nc)));
                dfs(new int[]{nr, nc}, visited, step + 1, countKey - 1, currentKey, grid);
            } else if (Character.isUpperCase(grid[nr].charAt(nc)) &&
                    currentKey.contains(grid[nr].charAt(nc))) {
                dfs(new int[]{nr, nc}, visited, step + 1, countKey, currentKey, grid);
            }

            currentKey.remove(Character.toUpperCase(grid[nr].charAt(nc)));
            visited[nr][nc] = false;
        }


    }

    private boolean isValid(int nr, int nc, int row, int col) {
        if (nc < 0 || nr < 0 || nr >= row || nc >= col) return false;
        return true;
    }

    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

}
