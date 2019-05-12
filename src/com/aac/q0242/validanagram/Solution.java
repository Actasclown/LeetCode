package com.aac.q0242.validanagram;

/**
 * Created by He at 19:28 2019/5/11
 */
public class Solution {
    public boolean isAnagram(String s, String t) {
        int len1 = s.length(), len2 = t.length();
        if(len1 != len2)
            return false;
        int[] alphaBeta1 = new int[26];
        int[] alphaBeta2 = new int[26];
        for (char i : s.toCharArray()) ++alphaBeta1[i - 'a'];
        for (char i : t.toCharArray()) ++alphaBeta2[i - 'a'];
        for (int i = 0; i < 26; i++)
            if(alphaBeta1[i] != alphaBeta2[i])
                return false;
        return true;
    }
}
