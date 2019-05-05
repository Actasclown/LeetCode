package com.aac.q0213.houserobberii;

public class Solution {
    public int robi(int[] nums) {
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

    public int rob(int[] nums) {
        if(nums == null)
            return 0;
        int length = nums.length;
        if(length == 0)
            return 0;
        if(length == 1)
            return nums[0];

        int[] numswithfirst = new int[length - 1];
        int[] numswithlast = new int[length - 1];
        for(int i = 0;i < length - 1;++i) {
            numswithfirst[i] = nums[i];
            numswithlast[i] = nums[i + 1];
        }

        return Math.max(robi(numswithfirst), robi(numswithlast));
    }

    public static void main(String[] args) {
        int[] input = {2, 3, 3};
        System.out.println(new Solution().rob(input));
    }
}
