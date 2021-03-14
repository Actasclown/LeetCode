package com.aac.wkt.q3;

import java.util.*;

public class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingDouble(i -> - (i[0] + 1) * 1.0f / (i[1] + 1) + i[0] * 1.0f / i[1]));
        for (int[] c : classes) {
            pq.offer(c);
        }
        for (int i = 0; i < extraStudents; i++) {
            int[] tmp = pq.poll();
            pq.offer(new int[] {tmp[0] + 1, tmp[1] + 1});
        }
        double ratios = 0;
        while(!pq.isEmpty()) {
            int[] tmp = pq.poll();
            ratios += tmp[0] * 1.0 / tmp[1];
        }
        return ratios / classes.length;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxAverageRatio(new int[][] {{2,4},{3,9},{4,5},{2,10}}, 4));
    }
}
