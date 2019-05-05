package com.aac.q0279.perfectsquares;

import java.util.Arrays;

public class Solution {
    private static int[] squares;
    private static int[] dp;

    public int numSquares(int n) {
        int sqrtn = (int) Math.sqrt(n);
        squares = new int[sqrtn + 1];
        for(int i = 1;i <= sqrtn;++i) {
            squares[i] = i * i;
        }
        dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1;i <= n;++i) {
            for(int j = 1;j <= sqrtn && squares[j] <= i;++j) {
                dp[i] = Math.min(dp[i], dp[i - squares[j]] + 1);
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numSquares(12));
    }
}
