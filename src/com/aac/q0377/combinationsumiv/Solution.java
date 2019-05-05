package com.aac.q0377.combinationsumiv;

public class Solution {
    public int combinationSum4(int[] nums, int target) {
        if (nums == null)
            return 0;
        int len = nums.length;
        if (len == 0 || target <= 0)
            return 0;

        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 1; i <= target; ++i) {
            for (int j = 0; j < len; ++j) {
                if(nums[j] <= i)
                    dp[i] = dp[i] + dp[i - nums[j]];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println(new Solution().combinationSum4(nums, 4));
    }
}
