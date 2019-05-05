package com.aac.q0091.decodeways;

public class Solution {
    private static int[] dp;

    public int numDecodings(String s) {
        int length = s.length();
        if(length == 0 || s == null || s.charAt(0) == '0')
            return 0;
        if(length == 1) {
            return 1;
        }

        dp = new int[length + 1];

        dp[0] = 1;
        dp[1] = 1;

        for(int i = 2;i <= length;++i) {
            int back2 = Integer.valueOf(s.substring(i - 2, i));
            if(s.charAt(i - 1) != '0')
                dp[i] = dp[i - 1];
            if(s.charAt(i - 2) != '0') {
                if (back2 <= 26 && back2 >= 1)
                    dp[i] += dp[i - 2];
            }
            if(dp[i] == 0)
                return 0;
        }

        return dp[length];
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numDecodings(new String("1010")));
    }
}
