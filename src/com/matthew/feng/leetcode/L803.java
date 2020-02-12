package com.matthew.feng.leetcode;

import java.util.Arrays;
import java.util.HashSet;

public class L803 {
    public static void main(String[] args) {
        L803 l = new L803();
        System.out.println(Arrays.toString(l.hitBricks(new int[][]{{1,0,0,0},{1,1,1,0}},new int[][]{{1,0}})));
        System.out.println(Arrays.toString(l.hitBricks(new int[][]{{1, 1, 1, 0, 1, 1, 1, 1}, {1, 0, 0, 0, 0, 1, 1, 1}, {1, 1, 1, 0, 0, 0, 1, 1}, {1, 1, 0, 0, 0, 0, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0}, {1, 0, 0, 0, 0, 0, 0, 0}}, new int[][]{{4, 6}, {3, 0}, {2, 3}, {2, 6}, {4, 1}, {5, 2}, {2, 1}})));
    }

    public int[] hitBricks(int[][] grid, int[][] hits) {
        int[] ans = new int[hits.length];
        int[][] directions = new int[][]{{0, 1}, {1, 0}, {-1, 0}, {0, -1}};
        for (int i = 0; i < hits.length; i++) {
            int x = hits[i][0];
            int y = hits[i][1];
            if (grid[x][y] == 0) {
                ans[i] = 0;
                continue;
            }
            grid[x][y] = 0;


            int totalCount = 0;
            for (int d = 0; d < directions.length; d++) {
                HashSet<Integer> visited = new HashSet<>();
                int nextX = x + directions[d][0];
                int nextY = y + directions[d][1];

                Pair pair = new Pair(0, false);
                dfs(nextX, nextY, grid, directions, visited, pair);
                if (!pair.valid) {
                    totalCount += pair.count;
                    for (int key : visited) {
                        grid[key / grid[0].length][key % grid[0].length] = 0;
                    }
                }
            }
            ans[i] = totalCount;

        }
        return ans;

    }

    private void dfs(int x, int y, int[][] grid, int[][] directions, HashSet<Integer> visited, Pair pair) {

        if (pair.valid) {
            return;
        }
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0)
            return;
        int key = x * grid[0].length + y;
        if (visited.contains(key)) return;
        visited.add(key);
        pair.count++;
        if (x == 0) {
            pair.valid = true;
            pair.count = 0;
        }

        for (int d = 0; d < directions.length; d++) {
            int nextX = x + directions[d][0];
            int nextY = y + directions[d][1];
            if (nextX < 0 || nextY < 0 || nextX >= grid.length || nextY >= grid[0].length || grid[nextX][nextY] == 0)
                continue;
            dfs(nextX, nextY, grid, directions, visited, pair);
        }

    }

    class Pair {
        int count;
        boolean valid;

        Pair(int count, boolean valid) {
            this.count = count;
            this.valid = valid;
        }
    }

}
