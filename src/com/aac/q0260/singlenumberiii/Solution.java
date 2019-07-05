package com.aac.q0260.singlenumberiii;

/**
 * Created by He at 16:25 2019/7/5
 */
public class Solution {
    public int[] singleNumber(int[] nums) {
        int diff = 0;
        for (int i : nums) {
            diff ^= i;
        }
        diff &= -diff;
        int[] ret = {0, 0};
        for(int i : nums) {
            if((i & diff) == 0)
                ret[0] ^= i;
            else
                ret[1] ^= i;
        }
        return ret;
    }
}
