package com.matthew.feng.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

public class L815 {
    public static void main(String[] args) {
        L815 l = new L815();
        System.out.println(l.numBusesToDestination2(new int[][]{{1, 2, 7}, {3, 6, 7}}, 1, 6));
        System.out.println(l.numBusesToDestination2(new int[][]{{7, 12}, {4, 5, 15}, {15, 19}, {9, 12, 13}}, 15, 12));
    }

    public int numBusesToDestination(int[][] routes, int S, int T) {

        HashMap<Integer, HashSet<Integer>> routeStop = new HashMap<>();
        HashMap<Integer, HashSet<Integer>> stopRoute = new HashMap<>();
        HashMap<Integer, Integer> numToT = new HashMap<>();

        for (int i = 0; i < routes.length; i++) {
            HashSet rs = routeStop.getOrDefault(i, new HashSet<>());
            if (routeStop.get(i) == null) {
                routeStop.put(i, rs);
            }
            for (int j = 0; j < routes[i].length; j++) {
                rs.add(routes[i][j]);
                HashSet sr = stopRoute.getOrDefault(routes[i][j], new HashSet<>());
                if (stopRoute.get(routes[i][j]) == null) {
                    stopRoute.put(routes[i][j], sr);
                }
                sr.add(i);
            }
        }
        HashSet<Integer> transferStop = new HashSet<>();
        transferStop.add(T);
        numToT.put(T, 0);
        boolean find = false;
        while (transferStop.size() > 0) {
            HashSet<Integer> t = new HashSet<>();
            for (Integer stop : transferStop) {
                if (find) break;
                int count = numToT.get(stop);
                for (int route : stopRoute.get(stop)) {
                    if (find) break;
                    for (Integer nextStop : routeStop.get(route)) {
                        if (!numToT.containsKey(nextStop)) {
                            numToT.put(nextStop, count + 1);
                            if (nextStop == S) {
                                find = true;
                            }
                            t.add(nextStop);
                        }

                    }
                }
            }
            transferStop = t;
        }


        return numToT.getOrDefault(S, -1);


    }

    public int numBusesToDestination2(int[][] routes, int S, int T) {

        if (S == T) return 0;

        HashMap<Integer, HashSet<Integer>> stopRoute = new HashMap<>();

        for (int i = 0; i < routes.length; i++) {
            for (int j = 0; j < routes[i].length; j++) {
                HashSet sr = stopRoute.getOrDefault(routes[i][j], new HashSet<>());
                if (stopRoute.get(routes[i][j]) == null) {
                    stopRoute.put(routes[i][j], sr);
                }
                sr.add(i);
            }
        }
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(S);
        HashSet<Integer> visitedRoutes = new HashSet<>();
        HashSet<Integer> visitedStops = new HashSet<>();
        visitedStops.add(S);

        int ans = 0;
        while (queue.size() > 0) {
            int queueSize = queue.size();
            ans++;
            while (queueSize > 0) {
                queueSize--;
                int stop = queue.poll();
                for (int route : stopRoute.get(stop)) {
                    if (!visitedRoutes.contains(route)) {
                        visitedRoutes.add(route);
                        for (int nextStop : routes[route]) {
                            if (nextStop == T)
                                return ans;
                            if (!visitedStops.contains(nextStop)) {
                                queue.offer(nextStop);
                                visitedStops.add(nextStop);
                            }
                        }
                    }
                }
            }
        }
        return -1;

    }
}
