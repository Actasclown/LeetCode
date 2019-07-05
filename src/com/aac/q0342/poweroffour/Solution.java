package com.aac.q0342.poweroffour;

/**
 * Created by He at 14:47 2019/7/4
 */
class Solution {
    public boolean isPowerOfFour(int num) {
        return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) != 0;
    }
}