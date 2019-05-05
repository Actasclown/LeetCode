package com.aac.q0053.maximumsubarray;

public class Solution {
//    public int maxSubArray(int[] nums) {
//        int len = nums.length;
//        for(int i = 1;i < len;++i)
//            nums[i] += nums[i - 1];
//
//        int valley = nums[0];
//        int sum = nums[0];
//        for (int i = 1;i < len;++i) {
//            if(nums[i] - valley > sum)
//                sum = nums[i] - valley;
//            if(nums[i] > sum)
//                sum = nums[i];
//            if(nums[i] < valley)
//                valley = nums[i];
//        }
//        return sum;
//    }   //O(n) space


    public int maxSubArray(int[] nums) {
        int max = nums[0], sum = nums[0];
        for (int i = 1; i < nums.length; ++i) {
            sum = (sum > 0 ? sum: 0) + nums[i];
            max = max > sum ? max : sum;
        }
        return max;
    }   //O(1) space

    public static void main(String[] args) {
        System.out.println(new Solution().maxSubArray(new int[]{1, 2}));
    }
}
