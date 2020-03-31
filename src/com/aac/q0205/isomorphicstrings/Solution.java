package com.aac.q0205.isomorphicstrings;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by He at 19:53 2019/5/11
 */
public class Solution {
//    public boolean isIsomorphic(String s, String t) {
//        int len1 = s.length(), len2 = t.length();
//        if(len1 != len2)
//            return false;
//        int[] alphaBeta = new int[128];
//        Arrays.fill(alphaBeta, -1);
//        Set<Character> mapping = new HashSet<>();
//        for (int i = 0; i < len1; i++) {
//            char a = s.charAt(i);
//            char b = t.charAt(i);
//            if(alphaBeta[a] == -1) {
//                if(mapping.contains(b))
//                    return false;
//                else {
//                    alphaBeta[a] = b;
//                    mapping.add(b);
//                }
//            }
//            else if(alphaBeta[a] != b)
//                return false;
//        }
//        return true;
//    }
    public boolean isIsomorphic(String s, String t) {
        char[] schar = s.toCharArray();
        char[] tchar = t.toCharArray();
        int length = s.length();
        int[] map = new int[256];
        for(int i = 0;i < 256;++i) {
            map[i] = -1;
        }
        for(int i = 0;i < length;++i) {
            if(map[schar[i]] == -1) {
                for(int j = 0;j < 256;++j) {
                    if(map[j] == tchar[i])
                        return false;
                }
                map[schar[i]] = tchar[i];
            }
            else if(map[schar[i]] != tchar[i])
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().isIsomorphic("aab", "eeg"));
    }
}
