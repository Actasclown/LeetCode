package com.aac.q0045.jumpgameii;

import java.util.Arrays;

public class Solution {
    public int jump(int[] nums) {
        if(nums.length == 1)
            return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 100000000);
        for (int i = nums.length - 1; i >= 0; --i) {
            if(nums[i] + i >= nums.length - 1)
                dp[i] = 1;
            else {
                for (int j = 0; j <= nums[i]; j++) {
                    dp[i] = Math.min(dp[i], 1 + dp[i + j]);
                }
            }
        }
        return dp[0];
    }
}
