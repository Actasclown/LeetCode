package com.aac.q0371.sumoftwointegers;

/**
 * Created by He at 18:33 2019/7/5
 */
public class Solution {
    public int getSum(int a, int b) {
        return b == 0 ? a : getSum(a ^ b, (a & b) << 1);
    }
}
