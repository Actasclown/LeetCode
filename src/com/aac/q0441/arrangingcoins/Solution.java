package com.aac.q0441.arrangingcoins;

public class Solution {
    public int arrangeCoins(int n) {
        int level = 1;
        while(n >= 0) {
            n -= level;
            ++ level;
        }
        return level - 2;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().arrangeCoins(4));
    }
}
