package com.aac.q0763.partitionlabels;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<Integer> partitionLabels(String S) {
        List<Integer> ret = new ArrayList<>();
        int[] lastIdxs = new int[26];
        for (int i = 0;i < 26;++i) {
            lastIdxs[i] = S.lastIndexOf('a' + i);
        }

        int len = S.length();
        int startIdx = 0, endIdx = lastIdxs[S.charAt(0) - 'a'];
        for(int i = 0;i < len;++i) {
            if(i < endIdx) {
                int lastIdx = lastIdxs[S.charAt(i) - 'a'];
                if(lastIdx > endIdx)
                    endIdx = lastIdx;
            } else {
                ret.add(endIdx - startIdx + 1);
                startIdx = endIdx + 1;
                if(startIdx < len)
                    endIdx = lastIdxs[S.charAt(startIdx) - 'a'];
                else
                    break;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        String input = "eccbbbbdec";
        System.out.println(new Solution().partitionLabels(input));
    }
}
