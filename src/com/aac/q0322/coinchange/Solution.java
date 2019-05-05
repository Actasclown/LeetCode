package com.aac.q0322.coinchange;

import java.util.Arrays;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        if(coins == null)
            return 0;
        int len = coins.length;
        if(len == 0 || amount <= 0)
            return 0;

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int i = 0;i < len;++i) {
            for(int j = coins[i];j <= amount;++j)
                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
        }
        int ret = dp[amount];
        return ret == amount + 1 ? -1 : ret;
    }

    public static void main(String[] args) {
        int[] coins = {2};
        System.out.println(new Solution().coinChange(coins, 3));
    }
}
