package com.aac.q0416.partitionequalsubsetsum;

import java.util.Arrays;

public class Solution {
//    public boolean canPartition(int[] nums) {
//        int sum = 0;
//        for (int i : nums)
//            sum += i;
//        if (sum % 2 == 1)
//            return false;
//        sum /= 2;
//        int length = nums.length;
//        boolean[] dp = new boolean[sum + 1];
//        for(int i = 1;i <= sum;++i) {
//            if(nums[0] == i)
//                dp[i] = true;
//        }
//        for (int i = 2; i <= length; ++i) {
//            for (int j = sum; j >= nums[i - 1]; --j) {
//                dp[j] = dp[j] || dp[j - nums[i - 1]];
//            }
//        }
//        return dp[sum];
//    } //   DP NumArray with optimised space

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums)
            sum += i;
        if (sum % 2 == 1)
            return false;
        sum /= 2;
        Arrays.sort(nums);
        return dfs(nums, 0, sum);
    } //   BFS NumArray

    private boolean dfs(int[] nums, int layer, int sum) {
        if(sum == 0)
            return true;
        int length = nums.length;
        for(int i = layer;i < length;++i) {
            if(nums[i] > sum)
                break;
            if(i > layer && nums[i] == nums[i - 1])
                continue;
            if(dfs(nums, i + 1, sum - nums[i]))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[] input = {1, 5, 11, 6, 1};
        System.out.println(new Solution().canPartition(input));
    }
}
