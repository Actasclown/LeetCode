package com.aac.q0139.wordbreak;

import java.util.Arrays;
import java.util.List;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int length = s.length();
        boolean[] isSubstringBreakable = new boolean[length + 1];
        isSubstringBreakable[0] = true;
        for(int i = 1;i <= length;++i) {
            for (String word : wordDict) {
                int wordLength = word.length();
                if(wordLength <= i && s.substring(i - wordLength, i).equals(word) && isSubstringBreakable[i - wordLength]) {
                    isSubstringBreakable[i] = true;
                    break;
                }
            }
//            for(int j = i - 1;j >= 0;--j) {
//                System.out.println(s.substring(j, i));
//                if(wordDict.contains(s.substring(j, i)) && isSubstringBreakable[j]) {
//                    isSubstringBreakable[i] = true;
//                    break;
//                }
//            }
        }
        return isSubstringBreakable[length];
    }

    public static void main(String[] args) {
        List<String> dict = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println(new Solution().wordBreak("catsdogs", dict));
    }
}
