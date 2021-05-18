package com.aac.q1864.minimumnumberofswapstomakethebinarystringalternating;

public class Solution {
    public int minSwaps(String s) {
        char[] cs = s.toCharArray();
        int[] n = new int[] {0, 0};
        for (int i = 0; i < cs.length; i++) {
            n[cs[i] - '0'] ++;
        }
        if(Math.abs(n[0] - n[1]) > 1)
            return -1;
        if(n[0] > n[1]) {
            return helper(cs, '0');
        }
        if(n[1] > n[0]) {
            return helper(cs, '1');
        }
        return Math.min(helper(cs, '0'), helper(cs, '1'));
    }

    int helper(char[] cs, char begin) {
        int res = 0;
        for (int i = 0; i < cs.length; i++) {
            if(cs[i] != begin)
                res ++;
            begin = begin == '1' ? '0' : '1';
        }
        return res / 2;
    }
}
