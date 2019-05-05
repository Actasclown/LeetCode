package com.aac.q0123.besttimetobuyandsellstockiii;

public class Solution {
//    public int maxProfit0(int[] prices, int begin, int end) {
//        int minPrice = Integer.MAX_VALUE;
//        int maxProfit = Integer.MIN_VALUE;
//        for(int i = begin;i < end;++i) {
//            int curPrice = prices[i];
//            if(curPrice < minPrice)
//                minPrice = curPrice;
//            if(curPrice - minPrice > maxProfit)
//                maxProfit = curPrice - minPrice;
//        }
//        return maxProfit == Integer.MIN_VALUE ? 0 : maxProfit;
//    }
//
//    public int maxProfit(int[] prices) {
//        int maxRet = 0;
//        int len = prices.length;
//        for(int i = 0;i < len;++i) {
//            maxRet = Math.max(maxProfit0(prices, 0, i) + maxProfit0(prices, i, len), maxRet);
//        }
//        return maxRet;
//    }   O(n^2) Muggle NumArray

    public int maxProfit(int[] prices) {
        int b1 = Integer.MIN_VALUE, b2 = Integer.MIN_VALUE;
        int s1 = 0, s2 = 0;
        for(int c : prices) {
            b1 = Math.max(b1, - c);
            s1 = Math.max(s1, b1 + c);
            b2 = Math.max(b2, s1 - c);
            s2 = Math.max(s2, b2 + c);
        }
        return s2;
    }

    public static void main(String[] args) {
        int[] input = {3, 3, 5, 0, 0, 3, 1, 4};
        System.out.println(new Solution().maxProfit(input));
    }
}
