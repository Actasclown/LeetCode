package com.aac.q0376.wigglesubsequence;

public class Solution {
    public int wiggleMaxLength(int[] nums) {
        int length = nums.length;
        if (nums == null || length == 0)
            return 0;
        boolean flat = true;
        boolean up = false;
        int wiggleLength = 1;
        for (int i = 1; i < length; ++i) {
            boolean trend = nums[i] > nums[i - 1];
            boolean equal = nums[i] == nums[i - 1];
            if(!equal) {
                if(flat) {
                    up = trend;
                    flat = false;
                    ++wiggleLength;
                } else {
                    if (trend != up) {
                        up = trend;
                        ++wiggleLength;
                    }
                }
            }
        }
        return wiggleLength;
    }

    public static void main(String[] args) {
        int[] input = {1, 17, 5, 10, 13, 15, 10, 5, 16, 8};
        System.out.println(new Solution().wiggleMaxLength(input));
    }
}
