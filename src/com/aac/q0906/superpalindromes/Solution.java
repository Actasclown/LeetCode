package com.aac.q0906.superpalindromes;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int superpalindromesInRange(String left, String right) {
        List<Long> palindromes = new ArrayList<>();
        long l = Long.parseLong(left);
        long r = Long.parseLong(right);
        for (long i = 1; i < 10; i++) {
            palindromes.add(i);
        }
        for (long i = 1; i < 10000; i++) {
            String leftPart = Long.toString(i);
            String rightPart = new StringBuilder(leftPart).reverse().toString();
            palindromes.add(Long.parseLong(leftPart + rightPart));
            for (long j = 0; j < 10; j++) {
                palindromes.add(Long.parseLong(leftPart + j + rightPart));
            }
        }
        int res = 0;
        for (long palindrome : palindromes) {
            long square = palindrome * palindrome;
            if(isP(Long.toString(square)) && l <= square && r >= square)
                res++;
        }
        return res;
    }

    boolean isP(String str) {
        return str.equals(new StringBuilder(str).reverse().toString());
    }
}
