package com.aac.q0494.targetsum;

public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        if (nums == null)
            return 0;
        int length = nums.length;
        if (length == 0)
            return 0;

        int sum = 0;
        for (int i : nums)
            sum += i;
        if(sum < S || (sum + S) % 2 == 1)
            return 0;

        int target = (sum + S) / 2;

        int[] dp = new int[target + 1];
        dp[0] = 1;

        for(int i = 0;i < length;++i) {
            int num = nums[i];
            for(int j = target;j >= num;--j) {
                dp[j] = dp[j] + dp[j - num];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        int[] inputArray = {1, 1, 1, 1, 1};
        System.out.println(new Solution().findTargetSumWays(inputArray, 3));
    }
}
