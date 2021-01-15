package com.aac.q0957.prisoncellsafterndays;

public class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        int len = cells.length;
        N = (N - 1) % 14 + 1;
        while(N > 0) {
            int[] tmp = new int[len];
            for (int i = 1; i < len - 1; i++) {
                if(cells[i - 1] == cells[i + 1]) {
                    tmp[i] = 1;
                }
            }
            for (int i = 0; i < len; i++) {
                cells[i] = tmp[i];
            }
            --N;
        }
        return cells;
    }
}
