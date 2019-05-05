package com.aac.q0650.twokeyskeyboard;

/**
 * Created by He at 21:20 2019/5/5
 */
public class Solution {
//    public int minSteps(int n) {
//        if(n < 2)
//            return 0;
//        int[] dp = new int[n + 1];
//        for(int i = 2;i <= n;++i) {
//            int min = Integer.MAX_VALUE;
//            for(int j = 1;j < i / 2;++j) {
//                if(i % j == 0)
//                    min = Math.min(min, dp[j] + i / j);
//            }
//            dp[i] = min;
//        }
//        return dp[n];
//    }   //dp solution

    public int minSteps(int n) {
        int As = 1;
        int clipBoard = 0;
        int count = 0;
        while (As != n) {
            if(n % As == 0) {
                count += 2;
                clipBoard = As;
                As += clipBoard;
            } else {
                ++count;
                As += clipBoard;
            }
        }
        return count;
    }   //best solution

    public static void main(String[] args) {
        System.out.println(new Solution().minSteps(6));
    }
}
