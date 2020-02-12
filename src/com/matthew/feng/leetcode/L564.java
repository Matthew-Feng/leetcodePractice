package com.matthew.feng.leetcode;

public class L564 {

    public static void main(String[] args) {
        L564 l = new L564();
        System.out.println(l.nearestPalindromic("11"));
    }

    public String nearestPalindromic(String n) {

        Long l = Long.valueOf(n);
        int length = n.length();

        if (length % 2 == 0) {
            int left = Integer.valueOf(n.substring(0, length / 2));
            StringBuilder sb = new StringBuilder(n.substring(length / 2));
            int right = Integer.valueOf(sb.reverse().toString());
            if (left == right) {
                long down = getLong(left - 1);
                long up = getLong(left + 1);
                return String.valueOf(l - down <= up - l ? down : up);
            } else {
                long down = getLong(left - 1);
                long mid = getLong(left);
                long up = getLong(left + 1);

                long ans = l - down <= up - l ? down : up;
                ans = Math.abs(l - ans) >= Math.abs(l - mid) ? ans : mid;
                return String.valueOf(ans);
            }

        } else {
            int left = Integer.valueOf(n.substring(0, length / 2 + 1));

            if (isPalindromic(n)) {
                long down = getLong2(left - 1);
                long up = getLong2(left + 1);
                return String.valueOf(l - down <= up - l ? down : up);
            } else {
                long down = getLong2(left - 1);
                long mid = getLong2(left);
                long up = getLong2(left + 1);

                long ans = l - down <= up - l ? down : up;
                ans = Math.abs(l - ans) <= Math.abs(l - mid) ? ans : mid;
                return String.valueOf(ans);
            }
        }
    }

    private boolean isPalindromic(String n) {
        StringBuilder sb = new StringBuilder(n);
        return sb.reverse().toString().equals(n);
    }

    private long getLong2(int left) {
        StringBuilder sb = new StringBuilder("" + left);
        StringBuilder sb2 = new StringBuilder("" + left);
        sb.append(sb2.reverse().toString().substring(1));
        return Long.valueOf(sb.toString());
    }

    private long getLong(int i) {
        StringBuilder sb = new StringBuilder("" + i);
        StringBuilder sb2 = new StringBuilder("" + i);
        sb = sb.append(sb2.reverse());
        return Long.valueOf(sb.toString());
    }
}
