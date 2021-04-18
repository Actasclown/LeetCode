package com.aac.q1047.removealladjecentduplicatesinstring;

public class Solution {
    public String removeDuplicates(String S) {
        char[] ori = S.toCharArray();
        int i = 0;
        for (int j = 0; j < S.length(); j++) {
            ori[i] = ori[j];
            if(i == 0 || ori[i] != ori[i - 1])
                i++;
            else
                i--;
        }
        return new String(ori, 0, i);
    }

    public static void main(String[] args) {
        System.out.print(new Solution().removeDuplicates("aabbccc"));
    }
}
