package com.matthew.feng.leetcode;

import java.util.TreeSet;

public class L855 {

    private TreeSet<Integer> seats;
    private int roomSize;

    public L855(int N) {
        seats = new TreeSet<>();
        roomSize = N;
    }

    public int seat() {
        if (seats.isEmpty()) {
            seats.add(0);
            return 0;
        }
        int dist = seats.first() - 0;
        int previous = 0;
        int previousSeat = 0;
        for (int i : seats) {
            int d = (i - previousSeat) / 2;
            if (d > dist) {
                dist = d;
                previous = previousSeat + d;
            }
            previousSeat = i;
        }
        int d = roomSize - 1 - seats.last();
        if (d > dist) {
            previous = roomSize - 1;
        }
        seats.add(previous);
        return previous;
    }

    public void leave(int p) {
        seats.remove(p);
    }

}