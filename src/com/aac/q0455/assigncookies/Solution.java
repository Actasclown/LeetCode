package com.aac.q0455.assigncookies;

import java.util.Arrays;

public class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0, j = 0;
        while (i < g.length && j < s.length) {
            if (g[i] <= s[j])
                ++i;
            ++j;
        }
        return i;
    }

    public static void main(String[] args) {
        int[] children = {1, 2, 3}, cookies = {1, 1};
        System.out.println(new Solution().findContentChildren(children, cookies));
    }
}
