package com.aac.wkt.q1;

public class Solution {
    public boolean makeEqual(String[] words) {
        int[] calc = new int[26];
        for(String word : words) {
            for(char i : word.toCharArray()) {
                calc[i - 'a']++;
            }
        }
        for(int i : calc) {
            if(i % words.length != 0) {
                return false;
            }
        }
        return true;
    }
}

