package com.matthew.feng.leetcode;

public class L289 {

    public static void main(String[] args) {
        L289 l = new L289();
        l.gameOfLife(new int[][]{{0, 1, 0}, {0, 0, 1}, {1, 1, 1}, {0, 0, 0}});
    }

    public void gameOfLife(int[][] board) {
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int liveNeighbor = getLiveNeighbor(board, i, j, m, n);
                if (board[i][j] == 1 && (liveNeighbor == 2 || liveNeighbor == 3)) {
                    board[i][j] = 3;
                } else if (board[i][j] == 0 && (liveNeighbor == 3)) {
                    board[i][j] = 2;
                }
            }

        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] >>= 1;
            }
        }


    }

    private int getLiveNeighbor(int[][] board, int i, int j, int m, int n) {
        int ans = 0;
        for (int s = Math.max(i - 1, 0); s < Math.min(i + 1, m); s++) {
            for (int t = Math.max(0, j - 1); t < Math.min(j + 1, n); t++) {
                ans += board[s][t] & 1;
            }
        }
        ans -= board[i][j] & 1;
        return ans;
    }
}
