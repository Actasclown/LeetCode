package com.aac.q0709.tolowercase;

public class Solution {
    public String toLowerCase(String s) {
        char[] sc = s.toCharArray();
        for (int i = 0; i < sc.length; i++) {
            sc[i] = (sc[i] >= 'A' && sc[i] <= 'Z') ? (char)(sc[i] + 32) : sc[i];
        }
        return String.valueOf(sc);
    }
}
