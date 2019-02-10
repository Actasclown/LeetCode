package com.aac.q680.validpalindromeii;

public class Solution {
    private boolean isPalindrome(char[] s, int startIdx, int endIdx) {
        while(startIdx < endIdx) {
            if(s[startIdx] != s[endIdx])
                return false;
            ++startIdx;

            --endIdx;
        }
        return true;
    }


    public boolean validPalindrome(String s) {
        char[] tmp = s.toCharArray();
        int i = 0, j = s.length() - 1;
        while(i < j) {
            if(tmp[i] != tmp[j])
                return isPalindrome(tmp, i + 1, j) || isPalindrome(tmp, i, j - 1);
            ++i;
            --j;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().validPalindrome("abfssgdhddhdgfba"));
    }
}
