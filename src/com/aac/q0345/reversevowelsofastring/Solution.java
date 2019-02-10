package com.aac.q0345.reversevowelsofastring;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    private Set<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

    public String reverseVowels(String s) {
        int i = 0, j = s.length() - 1;
        char[] ret = new char[j + 1];
        while(i <= j) {
            char chari = s.charAt(i);
            char charj = s.charAt(j);
            if(!vowels.contains(chari)) {
                ret[i] = chari;
                ++i;
            }
            else if(!vowels.contains(charj)) {
                ret[j] = charj;
                --j;
            }
            else {
                ret[i] = charj;
                ret[j] = chari;
                ++i;
                --j;
            }
        }
        return new String(ret);
    }

    public static void main(String[] args) {
        String input = "aeiou";
        System.out.println(new Solution().reverseVowels(input));
    }
}
