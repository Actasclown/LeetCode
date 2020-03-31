package com.aac.q0821.shortestdistancetoacharacter;

public class Solution {
    public int[] shortestToChar(String S, char C) {
        int length = S.length();
        char[] chars = S.toCharArray();
        int[] toRight = new int[length];
        int[] toLeft = new int[length];
        int left = Integer.MAX_VALUE;
        int right = Integer.MAX_VALUE;
        int[] ret = new int[length];
        for(int i = 0;i < length;++i) {
            int j = length - i - 1;
            if(chars[i] == C) {
                left = 0;
            } else if(left != Integer.MAX_VALUE) {
                left++;
            }
            toLeft[i] = left;
            if(chars[j] == C) {
                right = 0;
            } else if(right != Integer.MAX_VALUE){
                right++;
            }
            toRight[j] = right;
        }
        for (int i = 0; i < length; i++) {
            ret[i] = Math.min(toLeft[i], toRight[i]);
        }
        return ret;
    }
}
