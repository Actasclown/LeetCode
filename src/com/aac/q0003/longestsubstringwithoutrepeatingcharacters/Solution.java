package com.aac.q0003.longestsubstringwithoutrepeatingcharacters;

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] alphabeta = new int[256];
        for (int i = 0;i < alphabeta.length;++i) {
            alphabeta[i] = -1;
        }
        int begin = 0, end = 0;
        int ret = 0;
        char[] sChars = s.toCharArray();
        for(int i = 0;i < sChars.length;++i) {
            if(alphabeta[sChars[i]] < begin) {
                alphabeta[sChars[i]] = i;
                end++;
                if(end - begin > ret)
                    ret = end - begin;
            } else {
                begin = alphabeta[sChars[i]] + 1;
                alphabeta[sChars[i]] = i;
                end ++;
                if(end - begin > ret)
                    ret = end - begin;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring(" "));
    }
}
