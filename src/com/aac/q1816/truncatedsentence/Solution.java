package com.aac.q1816.truncatedsentence;

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
