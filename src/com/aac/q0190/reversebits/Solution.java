package com.aac.q0190.reversebits;

/**
 * Created by He at 13:51 2019/7/4
 */
public class Solution {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int ret = n & 1;
        for(int i = 0;i < 31;++i) {
            ret <<= 1;
            n >>= 1;
            ret = ret | (n & 1);
        }
        return ret;
    }
}