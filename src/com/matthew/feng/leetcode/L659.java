package com.matthew.feng.leetcode;

import java.util.HashMap;

public class L659 {
    public boolean isPossible(int[] nums) {
        HashMap<Integer, Integer> freq = new HashMap<>();
        HashMap<Integer, Integer> appendFreq = new HashMap<>();
        for (Integer i : nums) {
            freq.put(i, freq.getOrDefault(i, 0) + 1);
        }
        for (int i : nums) {
            if (freq.getOrDefault(i, 0) < 1) continue;
            if (appendFreq.getOrDefault(i, 0) > 0) {
                appendFreq.put(i, appendFreq.getOrDefault(i, 0) - 1);
                appendFreq.put(i + 1, appendFreq.getOrDefault(i + 1, 0) + 1);
            } else if (freq.getOrDefault(i + 1, 0) > 0 && freq.getOrDefault(i + 2, 0) > 0) {
                freq.put(i + 1, freq.get(i + 1) - 1);
                freq.put(i + 2, freq.get(i + 2) - 1);
                appendFreq.put(i + 3, appendFreq.getOrDefault(i + 3, 0) + 1);
            } else return false;
            freq.put(i, freq.get(i) - 1);
        }
        return true;
    }
}
