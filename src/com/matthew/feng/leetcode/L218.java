package com.matthew.feng.leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;

public class L218 {

    public List<int[]> getSkyline(int[][] buildings) {
        List<int[]> res = new LinkedList<>();
        List<int[]> heights = new ArrayList<>();
        for (int[] building : buildings) {
            heights.add(new int[]{building[0], -building[2]});
            heights.add(new int[]{building[1], building[2]});
        }
        Collections.sort(heights, (x, y) -> {
            if (x[0] == y[0]) return Integer.compare(x[1], y[1]);
            else return Integer.compare(x[0], y[0]);
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        int x = 0;
        int pre = 0;
        for (int[] h : heights) {
            if (h[1] < 0) {
                pq.offer(-h[1]);
            } else {
                pq.remove(h[1]);
            }
            int cur = pq.peek();
            if (cur != pre) {
                res.add(new int[]{h[0], cur});
            }
        }
        return res;
    }
}
