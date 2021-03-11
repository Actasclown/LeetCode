package com.aac.q0322.coinchange;

import java.util.Arrays;

public class Solution {
    
//    public int coinChange(int[] coins, int amount) {
//        if(coins == null)
//            return 0;
//        int len = coins.length;
//        if(len == 0 || amount <= 0)
//            return 0;
//
//        int[] dp = new int[amount + 1];
//        Arrays.fill(dp, amount + 1);
//        dp[0] = 0;
//        for(int i = 0;i < len;++i) {
//            for(int j = coins[i];j <= amount;++j)
//                dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
//        }
//        int ret = dp[amount];
//        return ret == amount + 1 ? -1 : ret;
//    }

    int minNum = Integer.MAX_VALUE;

    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        dfs(coins, coins.length - 1, amount, 0);
        return minNum == Integer.MAX_VALUE ? -1 : minNum;
    }

    void dfs(int[] coins, int curCoin, int leftAmount, int curUsed) {
        if(curCoin < 0)
            return;
        if(leftAmount % coins[curCoin] == 0) {
            minNum = Math.min(minNum, curUsed + leftAmount / coins[curCoin]);
            return;
        }
        for(int i = leftAmount / coins[curCoin];i >= 0;--i) {
            if(curUsed + i >= minNum)
                return;
            else {
                dfs(coins, curCoin - 1, leftAmount - i * coins[curCoin], curUsed + i);
            }
        }
    }

    public static void main(String[] args) {
        int[] coins = {186,419,83,408};
        System.out.println(new Solution().coinChange(coins, 6249));
    }
}
