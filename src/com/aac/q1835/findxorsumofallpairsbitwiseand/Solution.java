package com.aac.q1835.findxorsumofallpairsbitwiseand;

public class Solution {
    public int getXORSum(int[] arr1, int[] arr2) {
        int res = 0;
        int xa = 0;
        for (int i = 0; i < arr1.length; i++) {
            xa ^= arr1[i];
        }
        for (int i = 0; i < arr2.length; i++) {
            res ^= (xa & arr2[i]);
        }
        return res;
    }
}
