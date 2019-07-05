package com.aac.q0231.poweroftwo;

/**
 * Created by He at 14:58 2019/7/4
 */
public class Solution {
    public boolean isPowerOfTwo(int n) {
        return n > 0 && (n & (n - 1)) == 0;
    }
}
