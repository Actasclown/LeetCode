package com.aac.q1513.numberofsubstringswithonly1s;

public class Solution {
    public int numSub(String s) {
        int consist = 0, res = 0;
        for (char c : s.toCharArray()) {
            if(c == '0') {
                consist = 0;
            } else {
                consist += 1;
                res = (res + consist) % 1000000007;
            }
        }
        return res;
    }
}
