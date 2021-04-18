package com.aac.q1074.numberofsubmatricesthatsumtotarget;

import java.util.HashMap;

public class Solution {
    public int numSubmatrixSumTarget(int[][] matrix, int target) {
        int h = matrix.length, w = matrix[0].length;
        for (int i = 0; i < h; i++) {
            for (int j = 1; j < w; j++) {
                matrix[i][j] += matrix[i][j - 1];
            }
        }
        int res = 0;
        HashMap<Integer, Integer> columnPresum = new HashMap<>();
        for (int i = 0; i < w; i++) {
            for (int j = i; j < w; j++) {
                columnPresum.clear();
                columnPresum.put(0, 1);
                int cur = 0;
                for (int k = 0; k < h; k++) {
                    cur += (i > 0 ? (matrix[k][j] - matrix[k][i - 1]) : matrix[k][j]);
                    res += columnPresum.getOrDefault(cur - target, 0);
                    columnPresum.put(cur, columnPresum.getOrDefault(cur, 0) + 1);
                }
            }
        }
        return res;
    }
}
