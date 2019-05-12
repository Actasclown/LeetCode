package com.aac.q0409.longestpalindrome;

/**
 * Created by He at 21:17 2019/5/11
 */
public class Solution {
    public int longestPalindrome(String s) {
        int[] alphaBeta = new int[128];
        for(char i : s.toCharArray()) ++alphaBeta[i];
        int ret = 0;
        for(int i : alphaBeta) ret += (i / 2) * 2;
        if(ret < s.length()) ++ret;
        return ret;
    }
}
