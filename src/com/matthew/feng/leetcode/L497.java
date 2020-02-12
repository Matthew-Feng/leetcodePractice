package com.matthew.feng.leetcode;

import java.util.Arrays;
import java.util.Random;
import java.util.TreeMap;

public class L497 {

    private int[] prefixSums;
    private int[][] rects;

    private TreeMap<Integer, Integer> map = new TreeMap<>();

    public L497(int[][] rects) {
        this.rects = rects;
        this.prefixSums = new int[rects.length];
        int sum = 0;
        for (int i = 0; i < rects.length; i++) {
            sum = sum + getArea(rects[i]);
            map.put(sum, i);
        }
    }

    public static void main(String[] args) {
        L497 l = new L497(new int[][]{{-2, -2, -1, -1}, {1, 0, 3, 0}});
        System.out.println(Arrays.toString(l.pick()));
        System.out.println(Arrays.toString(l.pick()));
        System.out.println(Arrays.toString(l.pick()));
        System.out.println(Arrays.toString(l.pick()));
        System.out.println(Arrays.toString(l.pick()));
        System.out.println(Arrays.toString(l.pick()));
    }

    private int getArea(int[] rect) {
        return (rect[2] - rect[0] + 1) * (rect[3] - rect[1] + 1);
    }

    public int[] pick() {
        int key = new Random().nextInt(this.prefixSums[this.prefixSums.length - 1]) + 1;
        int i = getRect(key);
        int[] res = new int[2];
        res[0] = this.rects[i][0] + (prefixSums[i] - key) / (this.rects[i][3] - this.rects[i][1] + 1);
        res[1] = this.rects[i][1] + (prefixSums[i] - key) % (this.rects[i][3] - this.rects[i][1] + 1);
        return res;

    }

    public int[] pick2() {
        int key = new Random().nextInt(this.prefixSums[this.prefixSums.length - 1]) + 1;

        int i = map.ceilingKey(key);
        int[] res = new int[2];
        res[0] = this.rects[i][0] + (i - key) / (this.rects[i][3] - this.rects[i][1] + 1);
        res[1] = this.rects[i][1] + (i - key) % (this.rects[i][3] - this.rects[i][1] + 1);
        return res;

    }

    private int getRect(int key) {
        int l = 0;
        int h = prefixSums.length - 1;
        while (l < h) {
            int mid = (l + h) / 2;
            if (prefixSums[mid] == key) {
                return mid;
            }
            if (prefixSums[mid] > key) {
                h = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return l;
    }

    public void L497_2(int[][] rects) {
        this.rects = rects;
        this.prefixSums = new int[rects.length];
        prefixSums[0] = getArea(rects[0]);
        for (int i = 1; i < rects.length; i++) {
            prefixSums[i] = prefixSums[i - 1] + getArea(rects[i]);
        }
    }
}
