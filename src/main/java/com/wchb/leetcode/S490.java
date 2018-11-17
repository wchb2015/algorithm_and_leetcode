package com.wchb.leetcode;

/**
 * @date 11/16/18 9:45 AM
 */
public class S490 {


    public enum Dir {UP, DOWN, LEFT, RIGHT}

    boolean[][] visited;


    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        visited = new boolean[maze.length][maze[0].length];
        return dfs(maze, start, destination, visited);
    }

    private boolean dfs(int[][] maze, int[] start, int[] destination, boolean[][] visited) {

        if (visited[start[0]][start[1]]) return false;
        if (start[0] == destination[0] && start[1] == destination[1]) return true;
        visited[start[0]][start[1]] = true;

        for (Dir dir : Dir.values()) {
            if (!isFeasible(dir, start, maze)) continue;
            if (dfs(maze, getNextStart(dir, start, maze), destination, visited)) {
                return true;
            }
        }

        return false;
    }

    private int[] getNextStart(Dir dir, int[] start, int[][] maze) {
        int n = maze.length;
        int m = maze[0].length;
        int finalX = start[0];
        int finalY = start[1];
        if (dir == Dir.UP) {
            while (finalY > 0 && maze[finalX][finalY - 1] != 1) {
                finalY--;
            }
        } else if (dir == Dir.DOWN) {
            while (finalY < m - 1 && maze[finalX][finalY + 1] != 1) {
                finalY++;
            }
        } else if (dir == Dir.LEFT) {
            while (finalX > 0 && maze[finalX - 1][finalY] != 1) {
                finalX--;
            }
        } else if (dir == Dir.RIGHT) {
            while (finalX < n - 1 && maze[finalX + 1][finalY] != 1) {
                finalX++;
            }
        }
        return new int[]{finalX, finalY};
    }

    private boolean isFeasible(Dir dir, int[] start, int[][] maze) {
        int n = maze.length;
        int m = maze[0].length;
        if (dir == Dir.UP) {
            int newY = start[1] - 1;
            if (newY < 0 || maze[start[0]][newY] == 1) return false;
        } else if (dir == Dir.DOWN) {
            int newY = start[1] + 1;
            if (newY >= m || maze[start[0]][newY] == 1) return false;
        } else if (dir == Dir.LEFT) {
            int newX = start[0] - 1;
            if (newX < 0 || maze[newX][start[1]] == 1) return false;
        } else if (dir == Dir.RIGHT) {
            int newX = start[0] + 1;
            if (newX >= n || maze[newX][start[1]] == 1) return false;
        }
        return true;
    }


}
