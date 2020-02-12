package com.matthew.feng.leetcode;

import java.util.HashMap;

public class L205 {

    public static void main(String[] args) {
        L205 l = new L205();
        System.out.println(l.isIsomorphic("aa", "ab"));
    }

    public boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            Character cs = s.charAt(i);
            Character ct = t.charAt(i);
            Character cp = map.get(cs);
            if (cp == null && !map.values().contains(ct)) {
                map.put(cs, ct);
            } else if (cp == null && map.values().contains(ct)) {
                return false;
            } else if (!cp.equals(ct)) {
                return false;
            }

        }
        return true;
    }
}
