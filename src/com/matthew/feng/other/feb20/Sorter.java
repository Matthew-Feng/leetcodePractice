package com.matthew.feng.other.feb20;

import java.util.Arrays;

public class Sorter {
    public static void main(String[] args) {
        Sorter sorter = new Sorter();
        System.out.print(Arrays.toString(sorter.sort(new int[]{1, 2, 3, 4})));
    }

    //     1. Sorting numbers based on the number of 1's in their binary form and if equal use natural sorting. 
    public int[] sort(int[] a) {
        Integer[] array = new Integer[a.length];
        for (int i = 0; i < a.length; i++) {
            array[i] = a[i];
        }

        Arrays.sort(array, (x, y) -> {
            int ans = Integer.compare(Integer.bitCount(x), Integer.bitCount(y));
            if (ans == 0) {
                return Integer.compare(x, y);
            }
            return ans;
        });
        for (int i = 0; i < a.length; i++) {
            a[i] = array[i];
        }
        return a;
    }
}
