package com.aac.q0121.besttimetobuyandsellstock;

public class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = Integer.MIN_VALUE;
        for(int curPrice : prices) {
            if(curPrice < minPrice)
                minPrice = curPrice;
            if(curPrice - minPrice > maxProfit)
                maxProfit = curPrice - minPrice;
        }
        return maxProfit == Integer.MIN_VALUE ? 0 : maxProfit;
    }

    public static void main(String[] args) {
        int[] input = {7, 1, 5, 3, 6, 4};
        System.out.println(new Solution().maxProfit(input));
    }
}
