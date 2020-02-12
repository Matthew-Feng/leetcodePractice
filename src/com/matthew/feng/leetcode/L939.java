package com.matthew.feng.leetcode;

import java.util.HashSet;

public class L939 {

    public static void main(String[] args) {
        L939 l = new L939();
        System.out.println(l.minAreaRect(new int[][]{{1, 1}, {1, 3}, {3, 1}, {3, 3}, {4, 1}, {4, 3}}));
    }

    public int minAreaRect(int[][] points) {

        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < points.length; i++) {
            int key = points[i][0] * 40000 + points[i][1];
            set.add(key);
        }

        int area = Integer.MAX_VALUE;
        for (int i = 0; i < points.length - 1; i++) {
            for (int j = i + 1; j < points.length; j++) {
                int[] a = points[i];
                int[] b = points[j];
                if (a[0] != b[0] && a[1] != b[1]) {
                    int k1 = a[0] * 40000 + b[1];
                    int k2 = b[0] * 40000 + a[1];
                    if (set.contains(k1) && set.contains(k2)) {
                        int ar = getArea(a, b);
                        area = Math.min(area, ar);
                    }
                }
            }
        }
        if (area == Integer.MAX_VALUE) {
            return 0;
        }
        return area;
    }

    private int getArea(int[] a, int[] b) {
        return Math.abs((b[0] - a[0]) * (b[1] - a[1]));
    }
}
