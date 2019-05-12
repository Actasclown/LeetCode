package com.aac.q0696.countbinarysubstrings;

/**
 * Created by He at 20:47 2019/5/12
 */
public class Solution {
    public int countBinarySubstrings(String s) {
        int len = s.length();
        char[] ss = s.toCharArray();
        int pre = 0, cur = 1, cnt = 0;
        for(int i = 1;i < len;++i) {
            if(ss[i - 1] == ss[i]) {
                ++cur;
            } else {
                pre = cur;
                cur = 1;
            }
            if(pre >= cur) ++cnt;
        }
        return cnt;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().countBinarySubstrings("101"));
    }
}
