package com.aac.q0693.binarynumberwithalternatingbits;

/**
 * Created by He at 17:18 2019/7/5
 */
public class Solution {
    public boolean hasAlternatingBits(int n) {
        int tmp = n ^ (n >> 1);
        return ((tmp + 1) & tmp) == 0;
    }
}
