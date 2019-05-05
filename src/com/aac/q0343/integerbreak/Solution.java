package com.aac.q0343.integerbreak;

public class Solution {
    private static int[] dp;

    public int integerBreak(int n) {
        dp = new int[n + 1];
        dp[1] = 1;
        for(int i = 2;i <= n;++i) {
            for(int j = 1;j <= i - 1;++j) {
                dp[i] = Math.max(dp[i], Math.max(dp[i - j] * j, (i - j) * j));
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().integerBreak(10));
    }
}
