package com.aac.q1790.checkifonestringswapcanmakestringsequal;

public class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        if(s1.length() != s2.length())
            return false;
        int pos = -1;
        boolean swaped = false;
        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) {
                if(pos == -1)
                    pos = i;
                else {
                    if(!swaped) {
                        if(s1.charAt(i) == s2.charAt(pos) && s1.charAt(pos) == s2.charAt(i)) {
                            swaped = true;
                        } else {
                            return false;
                        }
                    } else {
                        return false;
                    }
                }
            }
        }
        if(pos != -1 && !swaped)
            return false;
        return true;
    }
}
