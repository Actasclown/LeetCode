package com.aac.q1827.minimumoperationstomakethearrayincreasing;

public class Solution {
    public int minOperations(int[] nums) {
        int cur = nums[0];
        int res = 0;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] <= cur) {
                res += (cur + 1 - nums[i]);
                cur = cur + 1;
            } else {
                cur = nums[i];
            }
        }
        return res;
    }
}
