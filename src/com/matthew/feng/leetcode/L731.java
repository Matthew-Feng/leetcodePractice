package com.matthew.feng.leetcode;

import java.util.LinkedList;
import java.util.List;

public class L731 {

    private List<int[]> books = new LinkedList<>();
    private List<int[]> overlaps = new LinkedList<>();

    public static void main(String[] args) {
        L731 l = new L731();
        System.out.println(l.book(28, 46));
        System.out.println(l.book(9, 21));
        System.out.println(l.book(21, 39));
        System.out.println(l.book(37, 48));
        System.out.println(l.book(38, 50));
        System.out.println(l.book(22, 39));
        System.out.println(l.book(45, 50));
        System.out.println(l.book(1, 12));
        System.out.println(l.book(40, 50));
        System.out.println(l.book(31, 44));
    }

    public boolean book(int start, int end) {

        for (int[] o : overlaps) {
            if (Math.max(o[0], start) < Math.min(o[1], end)) {
                return false;
            }
        }
        for (int[] book : books) {
            int s = Math.max(book[0], start);
            int e = Math.min(book[1], end);
            if (s < e) {
                overlaps.add(new int[]{s, e});
            }
        }
        books.add(new int[]{start, end});
        return true;
    }
}
