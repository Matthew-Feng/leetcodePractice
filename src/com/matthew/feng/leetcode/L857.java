package com.matthew.feng.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class L857 {

    public static void main(String[] args) {
        L857 l = new L857();
        System.out.println(l.minCostToHireWorkers(new int[]{3, 1, 10, 10, 1}, new int[]{4, 8, 2, 2, 7}, 3));
    }

    public double minCostToHireWorkers(int[] quality, int[] wage, int K) {
        int[][] workers = new int[quality.length][2];
        for (int i = 0; i < quality.length; i++) {
            workers[i][0] = quality[i];
            workers[i][1] = wage[i];
        }

        Arrays.sort(workers, Comparator.comparingDouble(x -> (double) x[1] / x[0]));

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(x -> -x[0]));
        int toalQuality = 0;
        double ratio = 0;
        double ans = Double.MAX_VALUE;
        for (int[] worker : workers) {
            toalQuality += worker[0];
            ratio = (double) worker[1] / worker[0];
            pq.offer(worker);
            if (pq.size() > K) {
                toalQuality = toalQuality - pq.poll()[0];
            }
            if (pq.size() == K) {
                ans = Math.min(ans, toalQuality * ratio);
            }
        }
        return ans;
    }
}
