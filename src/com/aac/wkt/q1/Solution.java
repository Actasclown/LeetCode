package com.aac.wkt.q1;

public class Solution {
    public String restoreString(String s, int[] indices) {
        int len = s.length();
        char[] tmp = new char[len];
        char[] ori = s.toCharArray();
        for (int i = 0; i < len; i++) {
            tmp[indices[i]] = ori[i];
        }
        return new String(tmp);
    }
}
