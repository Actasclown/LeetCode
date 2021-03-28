package com.aac.q1805.numberofdifferentintegersinastring;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int numDifferentIntegers(String word) {
        char[] wordChars = word.toCharArray();
        Set<Integer> words = new HashSet<>();
        int tmp = 0;
        boolean begin = false;
        for(char c : wordChars) {
            if(Character.isDigit(c)) {
                //System.out.println(c);
                //System.out.println(tmp);
                begin = true;
                tmp *= 10;
                tmp += (c - '0');
            } else {
                //System.out.println(tmp);
                if(begin)
                    words.add(tmp);
                begin = false;
                tmp = 0;
            }
        }
        if(Character.isDigit(wordChars[wordChars.length - 1])) {
            //System.out.println(tmp);
            words.add(tmp);
        }
        return words.size();
    }

    public static void main(String[] args) {
        System.out.println(new Solution().numDifferentIntegers("leet234code234"));
    }
}
