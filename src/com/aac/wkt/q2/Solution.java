package com.aac.wkt.q2;

public class Solution {
    public int minFlips(String target) {
        int len = target.length();
        char[] ori = target.toCharArray();
        char needToFlip = '1';
        int res = 0;
        for (int i = 0; i < len; i++) {
            if(ori[i] == needToFlip) {
                res++;
                needToFlip = needToFlip == '1' ? '0' : '1';
            }
        }
        return res;
    }
}
