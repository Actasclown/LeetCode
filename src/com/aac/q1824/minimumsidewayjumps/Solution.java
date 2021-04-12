package com.aac.q1824.minimumsidewayjumps;

public class Solution {
    public int minSideJumps(int[] obstacles) {
        int[][] dp = new int[obstacles.length][3];
        int magicBig = 1000000;
        for (int i = dp.length - 2; i >= 0; i--) {
            for (int j = 0; j < 3; j++) {
                dp[i][j] = dp[i + 1][j];
            }
            for (int j = 0; j < 3; j++) {
                for (int k = 0; k < 3; k++) {
                    if(k != j && k != obstacles[i] - 1) {
                        dp[i][j] = Math.min(dp[i + 1][k] + 1, dp[i][j]);
                    }
                }
            }
            if(obstacles[i] != 0) {
                dp[i][obstacles[i] - 1] = magicBig;
            }
            for (int j = 0; j < 3; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
        return dp[0][1];
    }

    public static void main(String[] args) {
        int[] test = new int[] {0,2,1,0,3,0};
        System.out.println(new Solution().minSideJumps(test));
    }
}
