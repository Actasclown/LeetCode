package com.aac.q1704.determineifstringhalvesarealike;

import java.util.HashSet;
import java.util.Set;

public class Solution {

    Set<Character> vowels;

    public Solution() {
        vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('A');
        vowels.add('E');
        vowels.add('I');
        vowels.add('O');
        vowels.add('U');
    }

    public boolean halvesAreAlike(String s) {
        String firstHalf = s.substring(0, s.length() / 2);
        String secondHalf = s.substring(s.length() / 2, s.length());
        System.out.println(firstHalf);
        System.out.println(secondHalf);
        return countVowel(firstHalf) == countVowel(secondHalf);
    }

    int countVowel(String input) {
        int res = 0;
        for(char i : input.toCharArray()) {
            if(vowels.contains(i))
                res++;
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().halvesAreAlike("abaabc");
    }
}
