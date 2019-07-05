package com.aac.q0136.singlenumber;

/**
 * Created by He at 15:04 2019/7/4
 */
public class Solution {
    public int singleNumber(int[] nums) {
        int ret = 0;
        for (int i : nums) {
            ret ^= i;
        }
        return ret;
    }
}
