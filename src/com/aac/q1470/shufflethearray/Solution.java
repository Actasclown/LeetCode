package com.aac.q1470.shufflethearray;

public class Solution {
    public int[] shuffle(int[] nums, int n) {
        int[] ret = new int[n * 2];
        for (int i = 0; i < n; i++) {
            ret[i * 2] =  nums[i];
            ret[i * 2 + 1] = nums[n + i];
        }
        return ret;
    }
}
