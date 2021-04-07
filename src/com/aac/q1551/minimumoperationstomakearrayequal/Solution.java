package com.aac.q1551.minimumoperationstomakearrayequal;

public class Solution {
    public int minOperations(int n) {
        int res = 0;
        if(n % 2 != 1) {
            n = n / 2;
            while (n > 0) {
                res += 2 * n - 1;
                n--;
            }
        } else {
            n = n / 2;
            while (n > 0) {
                res += 2 * n;
                n--;
            }
        }
        return res;
    }
}
