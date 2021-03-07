package com.aac.q1787.makethexorofallsegmentsequaltozero;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Solution {
    public int minChanges(int[] nums, int k) {
        int[][] freq = new int[k][1024];
        for (int i = 0; i < nums.length; i++) {
            freq[i % k][nums[i]]++;
        }
        int[][] dp = new int[k][1024];
        for (int i = 0; i < k; i++) {
            for (int j = 0; j < 1024; j++) {
                dp[i][j] = nums.length + 1;
            }
        }
        int mnm = 0;
        for (int i = 0; i < k; i++) {
            int total = 0, temp = nums.length + 1;
            for (int j = i; j < nums.length; j += k) {
                total++;
            }
            for (int j = 0; j < 1024; j++) {
                if(i == 0)
                    dp[i][j] = total - freq[i][j];
                else {
                    for (int ll = i; ll < nums.length; ll += k) {
                        int l = nums[ll];
                        dp[i][j] = Math.min(dp[i][j], dp[i - 1][j ^ l] + total - freq[i][l]);
                    }
                    dp[i][j] = Math.min(dp[i][j], mnm + total);
                }
                temp = Math.min(temp, dp[i][j]);
            }
            mnm = temp;
        }
        return dp[k - 1][0];
    }
}
