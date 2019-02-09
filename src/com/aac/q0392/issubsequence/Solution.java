package com.aac.q0392.issubsequence;

public class Solution {
    public boolean isSubsequence(String s, String t) {
        int pos = 0;
        for(int i = 0;i < s.length();++i, ++pos) {
            pos = t.indexOf(s.charAt(i), pos);
            if(pos == -1)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        String s = "abbc", t = "ahbngbc";
        System.out.println(new Solution().isSubsequence(s, t));
    }
}
