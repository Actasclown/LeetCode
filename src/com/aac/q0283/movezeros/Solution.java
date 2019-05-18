package com.aac.q0283.movezeros;

/**
 * Created by He at 21:43 2019/5/12
 */
public class Solution {
    public void moveZeroes(int[] nums) {
        int len = nums.length;
        int pointer = 0;
        for(int i = 0;i < len;++i) {
            if(nums[i] != 0) {
                nums[pointer++] = nums[i];
            }
        }
        for(int i = pointer;i < len;++i)
            nums[i] = 0;
    }
}
