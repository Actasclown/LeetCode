package com.aac.q0205.isomorphicstrings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by He at 19:53 2019/5/11
 */
public class Solution {
    public boolean isIsomorphic(String s, String t) {
        int len1 = s.length(), len2 = t.length();
        if(len1 != len2)
            return false;
        int[] alphaBeta = new int[128];
        Arrays.fill(alphaBeta, -1);
        Set<Character> mapping = new HashSet<>();
        for (int i = 0; i < len1; i++) {
            char a = s.charAt(i);
            char b = t.charAt(i);
            if(alphaBeta[a] == -1) {
                if(mapping.contains(b))
                    return false;
                else {
                    alphaBeta[a] = b;
                    mapping.add(b);
                }
            }
            else if(alphaBeta[a] != b)
                return false;
        }
        return true;
    }
}
