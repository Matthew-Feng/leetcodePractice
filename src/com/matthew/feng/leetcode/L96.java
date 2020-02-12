package com.matthew.feng.leetcode;

import java.util.HashMap;

public class L96 {

    public static void main(String[] args) {
        L96 l = new L96();
        System.out.println(l.numTrees2(19));
        System.out.println(l.numTrees2(3));
    }

    public int numTrees2(int n) {

        int[] dp = new int[n + 1];

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int ans = 0;
            for (int j = 1; j <= i; j++) {
                ans += dp[j - 1] * dp[i - j];
            }
            dp[i] = ans;
        }
        return dp[n];

    }

    public int numTrees(int n) {
        HashMap<Integer, Integer> memo = new HashMap<>();
        memo.put(0, 1);
        return helper(n, memo);
    }

    private int helper(int n, HashMap<Integer, Integer> memo) {
        Integer m = memo.get(n);
        if (m != null) {
            return m;
        }
        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans += numTrees(i - 1) * numTrees(n - i);
        }
        memo.put(n, ans);
        return ans;
    }
}
