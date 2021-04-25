package com.aac.q1837.sumofdigitsinbasek;

public class Solution {
    public int sumBase(int n, int k) {
        int res = 0;
        while(n > 0) {
            res += (n % k);
            n /= k;
        }
        return res;
    }
}
