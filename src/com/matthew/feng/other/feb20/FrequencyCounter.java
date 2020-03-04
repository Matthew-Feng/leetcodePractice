package com.matthew.feng.other.feb20;

import java.util.ArrayList;
import java.util.List;

public class FrequencyCounter {
    public static void main(String[] args) {
        FrequencyCounter.frequency("1226#(3)24#");

    }

    public static List<Integer> frequency(String s) {
        int[] count = new int[26];
        if (s != null && s.length() > 0) {
            int n = s.length();
            int i = 0;
            int index;

            while (i < n) {
                String st;
                int next2 = i + 2;
                if (next2 < n && s.charAt(next2) == '#') {
                    st = s.substring(i, i + 2);
                    i = i + 3;
                } else {
                    st = s.substring(i, i + 1);
                    i = i + 1;
                }
                index = Integer.parseInt(st);
                int num;
                if (i < n && s.charAt(i) == '(') {
                    int right = s.indexOf(')', i);
                    num = Integer.parseInt(s.substring(i + 1, right));
                    i = right + 1;
                } else {
                    num = 1;
                }
                count[index - 1] = count[index - 1] + num;
            }

        }
        List<Integer> ans = new ArrayList<>(26);
        for (int c : count) {
            ans.add(c);
        }
        return ans;
    }
}
