package com.aac.q0454.foursumii;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> ABsum = new HashMap<>();
        int len = A.length;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int oneSum = A[i] + B[j];
                ABsum.put(oneSum, ABsum.getOrDefault(oneSum, 0) + 1);
            }
        }
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                int twoSum = -(C[i] + D[j]);
                res += ABsum.getOrDefault(twoSum, 0);
            }
        }
        return res;
    }
}
