package com.aac.q0309.besttimetobuyandsellstockwithcooldown;

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null)
            return 0;
        int len = prices.length;
        if(len == 0)
            return 0;

        int[] s0 = new int[len + 1];
        int[] s1 = new int[len + 1];
        int[] s2 = new int[len + 1];
        s0[0] = 0;
        s1[0] = Integer.MIN_VALUE;
        s2[0] = 0;
        for (int i = 1;i <= len;++i) {
            s0[i] = Math.max(s2[i - 1], s0[i - 1]);
            s1[i] = Math.max(s0[i - 1] - prices[i - 1], s1[i - 1]);
            s2[i] = s1[i - 1] + prices[i - 1];
        }
        return Math.max(s0[len], s2[len]);
    }

    public static void main(String[] args) {
        System.out.println(new Solution().maxProfit(new int[]{1, 2, 3, 0, 2}));
    }
}
