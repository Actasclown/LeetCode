package com.aac.q1785.minimumelementstoaddtoformagivensum;

public class Solution {
    public int minElements(int[] nums, int limit, int goal) {
        long g = goal;
        for (int i = 0; i < nums.length; i++) {
            g -= nums[i];
        }
        g = Math.abs(g);
        long l = limit;
        return (int) (g / l + (((g % l) == 0) ? 0 : 1));
    }
}