package com.matthew.feng.leetcode;

public class L394 {
    public static String decodeString(String s) {
        if (s.length() == 0) return "";
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < s.length()) {
            if (!(s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                sb.append(s.charAt(i));
                i++;
            } else {
                int start = s.indexOf('[', i);
                int end = getEnd(s, start);
                int count = Integer.valueOf(s.substring(i, start));
                String internal = decodeString(s.substring(start + 1, end));
                for (int j = 0; j < count; j++) {
                    sb.append(internal);
                }
                i = end + 1;
            }

        }
        return sb.toString();
    }

    private static int getEnd(String s, int i) {
        int count = 0;
        for (int j = i; j < s.length(); j++) {
            if (s.charAt(j) == '[') {
                count++;
            } else if (s.charAt(j) == ']') {
                count--;
            }
            if (count <= 0) return j;
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(decodeString("3[a]2[bc]"));
        System.out.println(decodeString("2[abc]3[cd]ef"));
        System.out.println(decodeString("3[a2[c]]"));
    }
}
