package com.matthew.feng.leetcode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

public class L853 {

    public static void main(String[] args) {
        L853 l = new L853();
        System.out.println(l.carFleet(12, new int[]{10, 8, 0, 5, 3}, new int[]{2, 4, 1, 1, 3}));
        System.out.println(l.carFleet2(842818, new int[]{234601, 340195, 492544, 316935, 100648, 508398, 221368, 782081, 118569, 836954}, new int[]{170791, 421302, 732827, 311238, 926338, 282167, 792022, 638883, 265667, 978160}));
    }

    public int carFleet(int target, int[] position, int[] speed) {
        int[][] cars = new int[position.length][2];
        boolean[] fleeted = new boolean[position.length];
        for (int i = 0; i < position.length; i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }
        Arrays.sort(cars, Comparator.comparingInt(x -> x[0]));
        boolean merge = true;
        int fleet = position.length;
        while (merge) {
            merge = false;
            for (int i = 0; i < position.length - 1; ) {
                if (fleeted[i]) {
                    i++;
                    continue;
                }
                int next = i + 1;
                while (fleeted[next]) next++;
                if ((target - cars[next][0]) * (long) cars[i][1] >= (target - cars[i][0]) * (long) cars[next][1]) {
                    fleeted[i] = true;
                    merge = true;
                    fleet--;
                }
                i = next;
            }
        }
        return fleet;

    }

    public int carFleet2(int target, int[] position, int[] speed) {
        TreeMap<Integer, Double> cars = new TreeMap<>();
        for (int i = 0; i < position.length; i++) {
            cars.put(-position[i], (double) (target - position[i]) / speed[i]);
        }
        
        int feet = 0;
        double cur = 0;

        for (double time : cars.values()) {
            if (time > cur) {
                cur = time;
                feet++;
            }
        }
        return feet;
    }
}
