package com.aac.q0746.mincostclimbingstairs;

public class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = {cost[0], 0};
        int counter = 1;
        for (int i = 1;i < cost.length;++i) {
            dp[counter] = Math.min(dp[(counter + 1) % 2] + cost[i], dp[counter] + cost[i]);
            counter = (counter + 1) % 2;
        }
        return Math.min(dp[0], dp[1]);
    }
}
