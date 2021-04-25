package com.aac.q1838.frequencyofthemostfrequentelement;

import java.util.Arrays;

public class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0;
        int lastCount = 0;
        int lastUsed = 0;
        for (int i = 0; i < nums.length; i++) {
            int count = 1;
            int limit = k;
            int j = i - 1;
            if(i > 0) {
                int costToAddOne = lastCount * (nums[i] - nums[j]) + lastUsed;
                if(costToAddOne <= k) {
                    j = i - lastCount - 1;
                    limit = k - costToAddOne;
                    count = lastCount + 1;
                }
            }
            lastUsed = k - limit;
            for (; j >= 0; j--) {
                if(limit - (nums[i] - nums[j]) >= 0) {
                    limit -= (nums[i] - nums[j]);
                    count ++;
                } else {
                    lastUsed = k - limit;
                    break;
                }
            }
            lastCount = count;
            res = Math.max(count, res);
        }
        return res;
    }

    public static void main(String[] args) {
        int[] input1 = {9930,9923,9983,9997,9934,9952,9945,9914,9985,9982,9970,9932,9985,9902,9975,9990,9922,9990,9994,9937,9996,9964,9943,9963,9911,9925,9935,9945,9933,9916,9930,9938,10000,9916,9911,9959,9957,9907,9913,9916,9993,9930,9975,9924,9988,9923,9910,9925,9977,9981,9927,9930,9927,9925,9923,9904,9928,9928,9986,9903,9985,9954,9938,9911,9952,9974,9926,9920,9972,9983,9973,9917,9995,9973,9977,9947,9936,9975,9954,9932,9964,9972,9935,9946,9966};
        int input2 = 3056;
        //73Y,  85X
        System.out.println(new Solution().maxFrequency(input1, input2));
    }
}