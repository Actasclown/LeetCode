package com.aac.q0916.wordsubsets;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> wordSubsets(String[] A, String[] B) {
        List<String> res = new ArrayList<>();
        int[] counter = new int[26];
        for(int i = 0;i < B.length;i++) {
            char[] b = B[i].toCharArray();
            int tmp[] = new int[26];
            for(char c : b) {
                tmp[c - 'a']++;
            }
            for (int j = 0; j < 26; j++) {
                counter[j] = Math.max(counter[j], tmp[j]);
            }
        }
        for(String a : A) {
            char[] aChars = a.toCharArray();
            int[] aCounter = new int[26];
            for(char c : aChars) {
                aCounter[c-'a']++;
            }
            int j = 0;
            for(;j < 26;++j) {
                if(aCounter[j] < counter[j])
                    break;
            }
            if(j == 26)
                res.add(a);
        }
        return res;
    }

    public static void main(String[] args) {
        new Solution().wordSubsets(new String[] {"leetcode"}, new String[]{"e"});
    }
}
