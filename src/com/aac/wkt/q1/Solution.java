package com.aac.wkt.q1;

public class Solution {
    public String truncateSentence(String s, int k) {
        String[] ss = s.split(" ");
        StringBuilder sb = new StringBuilder();
        sb.append(ss[0]);
        for (int i = 1; i < k; i++) {
            sb.append(" ");
            sb.append(ss[i]);
        }
        return sb.toString();
    }
}

