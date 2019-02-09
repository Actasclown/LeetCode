package com.aac.q0665.nondecreasingarray;

public class Solution {
    public boolean checkPossibility(int[] nums) {
        int len = nums.length;
        int cnt = 0;
        for(int i = 1; i < len; ++i) {
            if(nums[i - 1] > nums[i]) {
                ++cnt;
                if(cnt > 1)
                    return false;
                if(i > 1 && nums[i - 2] > nums[i])
                    nums[i] = nums[i - 1];
                else
                    nums[i - 1] = nums[i];
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] input = {4, 2, 3};
        System.out.println(new Solution().checkPossibility(input));
    }
}
