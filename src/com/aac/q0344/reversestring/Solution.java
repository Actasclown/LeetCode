package com.aac.q0344.reversestring;

/**
 * Created by Yunqi on 2017/3/29.
 */
public class Solution {
    public String reverseString(String s) {
        char[] result = s.toCharArray();
        char tmp;
        int i = 0, j = s.length() - 1;
        while(i < j) {
            tmp = result[i];
            result[i] = result[j];
            result[j] = tmp;
            ++i;
            --j;
        }
        return new String(result);
    }
}