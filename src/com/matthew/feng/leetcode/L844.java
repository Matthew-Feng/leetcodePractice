package com.matthew.feng.leetcode;

public class L844 {

    public static void main(String[] args) {
        L844 l = new L844();
        System.out.println(l.backspaceCompare2("a#c", "b"));
        System.out.println(l.backspaceCompare2("nzp#o#g",
                "b#nzp#o#g"));
    }

    public boolean backspaceCompare(String S, String T) {
        String a = getString(S);
        String b = getString(T);
        return a.equals(b);
    }

    public boolean backspaceCompare2(String S, String T) {

        int i = S.length() - 1;
        int j = T.length() - 1;
        while (i >= -1 && j >= -1) {
            i = getIndex(S, i);
            j = getIndex(T, j);
            if (i >= 0 && j >= 0 && S.charAt(i) != T.charAt(j)) {
                return false;
            }
            i--;
            j--;
        }
        return (i == j);
    }

    private int getIndex(String t, int i) {
        while (i >= 0) {
            int skip = 0;
            while (i >= 0) {
                if (t.charAt(i) == '#') {
                    skip++;
                } else if (skip > 0) {
                    skip--;
                } else {
                    return i;
                }
                i--;
            }
        }
        return i;

    }

    private String getString(String s) {
        char[] a = s.toCharArray();
        int i = a.length - 1;
        StringBuilder sb = new StringBuilder();
        while (i >= 0) {
            int skip = 0;
            while (i >= 0) {
                if (a[i] == '#') {
                    skip++;
                } else if (skip > 0) {
                    skip--;
                } else {
                    sb.append(a[i]);
                }
                i--;
            }
        }
        return sb.toString();
    }
}
