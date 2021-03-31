package com.aac.q0354.russiadollenvelopes;

import java.util.Arrays;
import java.util.Comparator;

public class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length < 2)
            return envelopes.length;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] == o2[0] ? o2[1] - o1[1] : o1[0] - o2[0];
            }
        });
//        for (int[] envelope : envelopes) {
//            System.out.println(envelope[0] + " " + envelope[1]);
//        }
        int[] dp = new int[envelopes.length];
        int len = 0;
        for(int[] envelope : envelopes) {
            int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
            if(index < 0)
                index = -(index + 1);
            dp[index] = envelope[1];
            if(index == len)
                len ++;
        }
        return len;
    }

    public static void main(String[] args) {
        int[][] test = {{1, 1}, {1,2}, {2, 1}};
        new Solution().maxEnvelopes(test);
        int[] dp = {1, 2, 3, 4, 5};
        System.out.println(Arrays.binarySearch(dp, 0, 4, 5));
    }
}
