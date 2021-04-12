package com.aac.q1822.signoftheproductofanarray;

public class Solution {
    public int arraySign(int[] nums) {
        int res = 1;
        for (int num : nums) {
            if(num == 0)
                return 0;
            res *= (num / Math.abs(num));
        }
        return res;
    }
}
