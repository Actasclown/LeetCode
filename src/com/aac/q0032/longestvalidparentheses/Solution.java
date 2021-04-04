package com.aac.q0032.longestvalidparentheses;

public class Solution {
    public int longestValidParentheses(String s) {
        char[] sChars = s.toCharArray();
        int len = s.length();
        int ans = 0;
        int left = 0, right = 0;
        for (int i = 0; i < len; i++) {
            if(sChars[i] == '(')
                left++;
            else
                right++;
            if(left == right) {
                ans = Math.max(ans, left + right);
            } else if(right > left) {
                left = 0;
                right = 0;
            }
        }
        left = 0;
        right = 0;
        for (int i = len - 1; i >= 0; i--) {
            if(sChars[i] == '(')
                left++;
            else
                right++;
            if(left == right) {
                ans = Math.max(ans, left + right);
            } else if(right < left) {
                left = 0;
                right = 0;
            }
        }
        return ans;
    }
}
