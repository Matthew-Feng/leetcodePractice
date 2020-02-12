package com.matthew.feng.leetcode;

import java.util.HashMap;
import java.util.Map;

public class L947 {

    private Map<Integer, Integer> f = new HashMap<>();
    private int islands = 0;

    public int removeStones(int[][] stones) {
        boolean[][] visited = new boolean[stones.length][stones[0].length];

        int[] ans = new int[1];
        for (int i = 0; i < stones.length; i++) {
            for (int j = 0; j < stones[0].length; j++) {
                dfs(i, j, stones, visited, ans);
            }
        }
        return ans[0];

    }

    private void dfs(int i, int j, int[][] stones, boolean[][] vistited, int[] ans) {
        if (vistited[i][j]) return;
        vistited[i][j] = true;
        ans[0]++;
        for (int m = 0; m < stones.length; m++) {
            if (stones[m][j] == 1 && !vistited[m][j]) {
                dfs(m, j, stones, vistited, new int[1]);
            }
        }

    }

    public int removeStones2(int[][] stones) {
        for (int i = 0; i < stones.length; ++i)
            union(stones[i][0], ~stones[i][1]);
        return stones.length - islands;
    }

    public int find(int x) {
        if (f.putIfAbsent(x, x) == null)
            islands++;
        if (x != f.get(x))
            f.put(x, find(f.get(x)));
        return f.get(x);
    }

    public void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) {
            f.put(x, y);
            islands--;
        }
    }

}
