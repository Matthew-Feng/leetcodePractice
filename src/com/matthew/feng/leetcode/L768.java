package com.matthew.feng.leetcode;

public class L768 {

    public static void main(String[] args) {
        L768 l = new L768();
        System.out.println(l.maxChunksToSorted(new int[]{1, 0, 1, 3, 2}));
    }

    public int maxChunksToSorted(int[] arr) {

        int[] maxs = new int[arr.length];
        int[] mins = new int[arr.length];
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                max = arr[i];
            }
            maxs[i] = max;
        }
        int ans = 0;
        for (int j = arr.length - 1; j > 0; j--) {
            if (min > arr[j]) {
                min = arr[j];
            }
            if (min >= maxs[j - 1]) {
                ans++;
            }
        }
        return ans + 1;
    }
}
