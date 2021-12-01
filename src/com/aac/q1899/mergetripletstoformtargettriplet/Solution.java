package com.aac.q1899.mergetripletstoformtargettriplet;

class Solution {

    public boolean mergeTriplets(int[][] triplets, int[] target) {
        int[] ret = {0, 0, 0};
        for(int[] t : triplets) {
            if(t[0] <= target[0] && t[1] <= target[1] && t[2] <= target[2]) {
                ret[0] = Math.max(t[0], ret[0]);
                ret[1] = Math.max(t[1], ret[1]);
                ret[2] = Math.max(t[2], ret[2]);
            }
        }
        return ret[0] == target[0] && ret[1] == target[1] && ret[2] == target[2];
    }
}
