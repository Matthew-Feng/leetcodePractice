package com.matthew.feng.leetcode;

public class L686 {
    public int repeatedStringMatch(String A, String B) {
        int count = (B.length() + A.length() - 1) / A.length();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < count; i++) {
            sb.append(A);
        }
        if (sb.toString().contains(B)) {
            return count;
        }
        sb.append(A);
        if (sb.toString().contains(B)) {
            return count + 1;
        }
        return -1;
    }
}
