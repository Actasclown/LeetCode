package com.aac.q1869.longercontiguoussegmentsofonesthanzeros;

public class Solution {
    public boolean checkZeroOnes(String s) {
        char[] cs = s.toCharArray();
        int[] l = new int[2];
        int cur = 0;
        int thisNum = -1;
        for (int i = 0; i < cs.length; i++) {
            if(cs[i] == thisNum + '0') {
                cur += 1;
            } else {
                cur = 1;
                thisNum = cs[i] - '0';
            }
            l[thisNum] = Math.max(l[thisNum], cur);
        }
        return l[1] > l[0];
    }
}
