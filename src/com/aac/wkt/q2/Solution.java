package com.aac.wkt.q2;

import java.util.Arrays;

public class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int i = 0;
        for(int cost : costs) {
            if(coins >= cost) {
                coins -= cost;
                i ++;
            }
        }
        return i;
    }
}
