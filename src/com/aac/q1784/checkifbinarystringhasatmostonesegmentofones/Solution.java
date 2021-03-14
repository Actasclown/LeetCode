package com.aac.q1784.checkifbinarystringhasatmostonesegmentofones;

public class Solution {
    public boolean checkOnesSegment(String s) {
        char[] chars = s.toCharArray();
        char before = ' ';
        int oneCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if(chars[i] == '1') {
                if(before == '1')
                    continue;
                else
                    oneCount++;
            }
            before = chars[i];
            if(oneCount > 1)
                return false;
        }
        return true;
    }
}
