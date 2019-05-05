package com.aac.q0188.besttimetobuyandsellstockiv;

import java.util.Arrays;

public class Solution {
    public int maxProfit(int k, int[] prices) {
        int len = prices.length;
        if (k > len / 2) {
            int max = 0;
            for(int i = 1;i < len;++i) {
                if(prices[i] > prices[i - 1])
                    max += prices[i] - prices[i - 1];
            }
            return max;
        }
        int[] b = new int[k];
        int[] s = new int[k + 1];
        Arrays.fill(b, Integer.MIN_VALUE);
        for (int c : prices) {
            for (int i = 0; i < k; ++i) {
                b[i] = Math.max(b[i], s[i] - c);
                s[i + 1] = Math.max(s[i + 1], b[i] + c);
            }
        }
        return s[k];
    }   //O(kn) time O(n) space 1ms perfect solution

//    public int maxProfit(int k, int[] prices) {
//        int n = prices.length;
//        if (k >= n/2) {
//            int maxPro = 0;
//            for (int i = 1; i < n; i++) {
//                if (prices[i] > prices[i-1])
//                    maxPro += prices[i] - prices[i-1];
//            }
//            return maxPro;
//        }
//        int[][] dp = new int[k + 1][n];
//        for (int i = 1; i <= k; i++) {
//            int localMax = dp[i - 1][0] - prices[0];
//            for (int j = 1; j < n; j++) {
//                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + localMax);
//                localMax = Math.max(localMax, dp[i - 1][j] - prices[j]);
//            }
//        }
//        return dp[k][n - 1];
//    }   //O(kn) time O(kn) space 2ms dp solution

    public static void main(String[] args) {
        int[] input = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(new Solution().maxProfit(2, input));
    }
}
