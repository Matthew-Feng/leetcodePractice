package com.matthew.feng.other.feb20;

public class MaximumDifferentFinder {
    public int maximumDifferent(int[] a) {
        int ans = Integer.MIN_VALUE;
        if (a.length <= 1) {
            return ans;
        }
        int min = a[0];
        for (int i = 1; i < a.length; i++) {
            ans = Math.max(ans, a[i] - min);
            min = Math.min(min, a[i]);
        }
        if (ans <= 0) {
            ans = Integer.MIN_VALUE;
        }
        return ans;
    }

}
