package com.matthew.feng.leetcode;


import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class L187 {
    public static void main(String[] args) {
        L187 l = new L187();
        System.out.println(l.findRepeatedDnaSequences2("AAAAAAAAAAA"));
    }

    public List<String> findRepeatedDnaSequences(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);
            int prei = map.getOrDefault(sub, Integer.MAX_VALUE);
            if (i - prei >= 10) {
                set.add(sub);
            } else {
                map.put(sub, i);
            }
        }
        return new LinkedList<>(set);
    }

    public List<String> findRepeatedDnaSequences2(String s) {
        HashSet<String> all = new HashSet<>();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i <= s.length() - 10; i++) {
            String sub = s.substring(i, i + 10);
            if (all.contains(sub)) {
                set.add(sub);
            }
            all.add(sub);
        }
        return new LinkedList<>(set);
    }
}
