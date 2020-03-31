package com.aac.q0191.numberof1bits;

public class Solution {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int ret = 0;
        while (n != 0) {
            ret += (n & 1);
            n >>>= 1;
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().hammingWeight(-1));
    }
}