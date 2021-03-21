package com.aac.wkt.q1;

public class Solution {
    public int maxAscendingSum(int[] nums) {
        int curSum = 0;
        int maxSum = 0;
        int lastNum = 0;
        for (int i : nums) {
            if(i > lastNum) {
                curSum += i;
            } else {
                curSum = i;
            }
            if(curSum > maxSum) {
                maxSum = curSum;
            }
            lastNum = i;
        }
        return maxSum;
    }
}

