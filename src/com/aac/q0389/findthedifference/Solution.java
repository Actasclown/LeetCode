package com.aac.q0389.findthedifference;

/**
 * Created by He at 15:06 2019/7/4
 */
public class Solution {
    public char findTheDifference(String s, String t) {
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        char ret = 0;
        for (char i : s1) {
            ret ^= i;
        }
        for (char i : t1) {
            ret ^= i;
        }
        return ret;
    }
}
