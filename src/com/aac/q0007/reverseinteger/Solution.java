package com.aac.q0007.reverseinteger;

public class Solution {
    public int reverse(int x) {
        int ret = 0;
        while(x != 0) {
            if(Integer.MAX_VALUE / ret < 10)
                return 0;
            ret *= 10;
            ret += (x % 10);
            x /= 10;
        }
        return ret;
    }
}
