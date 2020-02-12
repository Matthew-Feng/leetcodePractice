package com.matthew.feng.leetcode;

public class L263 {
    private static int[] a = new int[]{2, 3, 5};

    public boolean isUgly(int num) {
        if (num <= 0) return false;
        if (num == 1) return true;

        for (int i = 0; i < a.length; i++) {
            if (num == a[i]) return true;

            if (num % a[i] == 0 && isUgly(num / a[i])) return true;
        }
        return false;
    }
}
