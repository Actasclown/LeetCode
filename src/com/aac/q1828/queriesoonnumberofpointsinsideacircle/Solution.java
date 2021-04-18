package com.aac.q1828.queriesoonnumberofpointsinsideacircle;

public class Solution {
    public int[] countPoints(int[][] points, int[][] queries) {
        int[] res = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x = queries[i][0];
            int y = queries[i][1];
            int r = queries[i][2];
            for (int[] point : points) {
                if((x - point[0]) * (x - point[0]) + (y - point[1]) * (y - point[1]) <= r * r)
                    res[i]++;
            }
        }
        return res;
    }
}
