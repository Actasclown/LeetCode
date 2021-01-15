package com.aac.q0678.validparenthesisstring;

public class Solution {
    public boolean checkValidString(String s) {
        char[] sChars = s.toCharArray();
        int len = sChars.length - 1;
        int left = 0, right = 0;
        for(int i = 0;i <= len;++i) {
            if(sChars[i] == '(' || sChars[i] == '*')
                left++;
            else
                left--;
            if(sChars[len - i] == ')' || sChars[len - i] == '*')
                right++;
            else
                right--;
            if(left < 0 || right < 0)
                return false;
        }
        return true;
    }
}
