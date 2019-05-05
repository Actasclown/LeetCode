package com.aac.q0198.houserobber;

public class Solution {
    public int rob(int[] nums) {
        if(nums == null)
            return 0;
        int len = nums.length;
        if(len == 0)
            return 0;
        int[] sum = new int[len + 1];
        sum[0] = 0;
        sum[1] = nums[0];
        for (int i = 2; i <= len; ++i) {
            sum[i] = Math.max(sum[i - 1], sum[i - 2] + nums[i - 1]);
        }
        return sum[len];
    }

    public static void main(String[] args) {
        int[] input = {2, 1};
        System.out.println(new Solution().rob(input));
    }
}
