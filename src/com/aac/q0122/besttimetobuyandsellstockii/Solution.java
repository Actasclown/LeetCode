package com.aac.q0122.besttimetobuyandsellstockii;

public class Solution {
    public int maxProfit(int[] prices) {
        int sum = 0;
        for(int i = 0;i < prices.length - 1;++i) {
            int gap = prices[i + 1] - prices[i];
            if(gap > 0)
                sum += gap;
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] input = {7,1,5,3,6,4};
        System.out.println(new Solution().maxProfit(input));
    }
}
