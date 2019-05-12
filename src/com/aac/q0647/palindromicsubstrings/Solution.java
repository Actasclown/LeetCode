package com.aac.q0647.palindromicsubstrings;

import java.util.Arrays;

/**
 * Created by He at 18:34 2019/5/12
 */
public class Solution {
//    public int countSubstrings(String s) {
//        char[] ss = s.toCharArray();
//        int len = ss.length;
//        if(len < 2)
//            return len;
//        boolean[][] isPalindromic = new boolean[len + 1][len];
//        int ret = len;
//        Arrays.fill(isPalindromic[1], true);
//        for(int i = 1;i < len;++i) {
//            if(ss[i] == ss[i - 1]) {
//                ++ret;
//                isPalindromic[2][i] = true;
//            }
//        }
//        for(int i = 3;i <= len;++i) {
//            for(int j = i - 1;j < len;++j) { //i for length of sub, j for end position
//                if(isPalindromic[i - 2][j - 1] && ss[j] == ss[j - i + 1]) {
//                    ++ret;
//                    isPalindromic[i][j] = true;
//                }
//            }
//        }
//        return ret;
//    }

    private int cnt = 0;

    public int countSubstrings(String s) {
        char[] ss = s.toCharArray();
        int len = ss.length;
        for(int i = 0;i < len;++i) {
            extendPalindrome(ss, i, i, len);
            extendPalindrome(ss, i, i + 1, len);
        }
        return cnt;
    }

    private void extendPalindrome(char[] ss, int start, int end, int length) {
        while(start >= 0 && end < length) {
            if(ss[start] == ss[end]) {
                cnt ++;
                start--;
                end++;
            } else
                return;
        }
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countSubstrings("aba"));
    }
}
