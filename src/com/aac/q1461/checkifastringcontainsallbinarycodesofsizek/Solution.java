package com.aac.q1461.checkifastringcontainsallbinarycodesofsizek;

import java.util.HashSet;

public class Solution {
    public boolean hasAllCodes(String s, int k) {
        int expectedSize = 1;
        for (int i = 0; i < k; i++) {
            expectedSize <<= 1;
        }
        int length = s.length();
        if(s.length() - k + 1 < expectedSize)
            return false;
        char[] sChars = s.toCharArray();
        HashSet<Integer> codes = new HashSet<>();
        int base = 0;
        for (int i = 0; i < k; i++) {
            base = base * 2 + (sChars[i] - '0');
        }
        codes.add(base);
        for(int i = 1;i < s.length() - k + 1;++i) {
            base = base * 2 - (sChars[i - 1] - '0') * expectedSize + (sChars[i + k - 1] - '0');
            codes.add(base);
            if(codes.size() == expectedSize)
                return true;
        }
        return false;
    }
}
